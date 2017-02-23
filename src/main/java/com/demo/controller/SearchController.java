package com.demo.controller;


import com.demo.from.LoginFrom;
import com.demo.from.SetFrom;
import com.demo.model.User;
import com.demo.model.Waps;
import com.demo.service.WapsService;
import com.demo.util.CommonUtil;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RequestMapping("search")
@Controller
public class SearchController {

	@RequestMapping("/index")
	public String index() {
		
		return "search/index";
	}

	@Autowired
	private WapsService wapsService;

	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
	public List<Waps> queryIndexs(@RequestParam("keywords") String keywords,@RequestParam(value ="current",defaultValue = "1") int current,@RequestParam( value = "limit",defaultValue = "20") int limit) {
		List<Waps> wapses = wapsService.query(keywords,current,limit);
		return wapses;
	}
	@RequestMapping(value = "query", method = RequestMethod.GET, produces = "application/json")
	public String setting(@Validated SetFrom from, BindingResult result, HttpSession session, Model model) throws UserException {
		 Waps waps = new Waps();

		 waps.setIsPop(from.getIsPop());
		 waps.setUserId(from.getUserId());
		 waps.setWapId(from.getWapId());
		 waps.setWapMoney(from.getWapMoney());
		 waps.setWapDesc(from.getWapDesc());
		 waps.setWapKeyWord(from.getWapKeyWord());
		 waps.setWapTitle(from.getWapTitle());
		 waps.setWapUrl(from.getWapUrl());
		 boolean res = wapsService.insert(waps);
	        // 用户不存在
	        if(res){
	            model.addAttribute("msg", CommonUtil.getTipMsg("MANAGERNOTFOUNT"));

	            return "set/success";
	        }
	}

}
