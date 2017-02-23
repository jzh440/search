
package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.from.LoginFrom;
import com.demo.model.User;
import com.demo.service.LoginServiceImpl;
import com.demo.util.CommonUtil;
import com.demo.validator.LoginValidator;

@RequestMapping("login")
@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {

	        binder.setValidator(new LoginValidator());
	   }
	 
	@RequestMapping("/index")
	public String index() {
		
		return "login/index";
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String login(@Validated LoginFrom from, BindingResult result, HttpSession session, Model model) throws UserException {

	        User user = new User();
	        if (result.hasErrors()){
	            model.addAttribute("allErrors", result.getAllErrors());
	            return "login/index";
	        }

	        user.setUserName(from.getUserName());
	        user.setPassword(from.getPassword());
	        User resultUser = loginService.login(user);
	        // 用户不存在
	        if(resultUser == null){
	            model.addAttribute("msg", CommonUtil.getTipMsg("MANAGERNOTFOUNT"));

	            return "login/index";
	        }
	     
	        return "redirect:/main/homePage";
	    }
}
