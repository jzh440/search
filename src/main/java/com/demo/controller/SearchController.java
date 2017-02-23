package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("search")
@Controller
public class SearchController {

	@RequestMapping("/index")
	public String index() {
		
		return "search/index";
	}
}
