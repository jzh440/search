package com.demo.controller;

import com.demo.model.Waps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("search")
@Controller
public class SearchController {

	@RequestMapping("/index")
	public String index() {
		
		return "search/index";
	}

	/**
	 * 查询统计指标
	 *
	 * @return
	 */
	@RequestMapping(value = "query", method = RequestMethod.GET, produces = "application/json")
	public List<Waps> queryIndexs(@RequestParam("keywords") String keywords,@RequestParam(value ="current",defaultValue = "1") int current,@RequestParam( value = "limit",defaultValue = "20") int limit) {
		List<Waps> wapses = new ArrayList<>();
		wapses.add(new Waps("1","2","3"));
		wapses.add(new Waps("1","2","3"));
		wapses.add(new Waps("1","2","3"));
		return wapses;
	}

}
