package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login")
@Controller
public class LoginController {

	@RequestMapping("/index")
	public String index() {
		
		return "login/index";
	}
}
