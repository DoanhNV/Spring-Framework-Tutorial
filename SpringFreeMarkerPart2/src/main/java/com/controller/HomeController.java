package com.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String loadHomePage() {
		return "escape";
	}
	
	@RequestMapping("/whitespace")
	public String handleWhiteSpace() {
		return "white-space";
	}
	
	@RequestMapping("/equare")
	public String useSpquare() {
		return "square";
	}
	
	@RequestMapping("/buildin") 
	public String processBuildInt(ModelMap modelMap){
		modelMap.addAttribute("currentDate", new Date());
		return "buildin";
	}
}	
