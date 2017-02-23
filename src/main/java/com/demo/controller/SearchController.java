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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> queryIndexs(@RequestParam("keywords") String keywords,@RequestParam(value ="current",defaultValue = "1") int current,@RequestParam( value = "limit",defaultValue = "20") int limit) {
		long startTime = System.currentTimeMillis();
		int count = wapsService.count(keywords);
		List<Waps> wapses = wapsService.query(keywords,current,limit);
		long endTime = System.currentTimeMillis();
		Map<String,Object> result = new HashMap<>();
		result.put("count",count);
		result.put("wapses",wapses);
		result.put("time",endTime-startTime);
		return result;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST,consumes ="application/json", produces = "application/json")
	public boolean setting(@RequestBody Waps waps, BindingResult result) throws UserException {
		if(!result.hasErrors()){
			return false;
		}
		return wapsService.insert(waps);
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST,consumes ="application/json", produces = "application/json")
	public boolean edit(@RequestBody Waps waps, BindingResult result) throws UserException {
		if(!result.hasErrors()){
			return false;
		}
		return wapsService.edit(waps);
	}

	@RequestMapping(value = "del", method = RequestMethod.POST,consumes ="application/json" ,produces = "application/json")
	public boolean del(@RequestBody int[] ids, BindingResult result) throws UserException {
		if(!result.hasErrors()){
			return false;
		}
		return wapsService.delete(ids);
	}

}
