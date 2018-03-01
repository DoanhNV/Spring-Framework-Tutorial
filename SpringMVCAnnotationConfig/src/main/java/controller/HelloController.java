package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import entity.User;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String redirecter(RedirectAttributesModelMap redirectAttributesModelMap) {
		redirectAttributesModelMap.addAttribute("userName", "Never back down");
		return "redirect:hello";
	}
	
	@RequestMapping("/hello")
	public String proccessRequest(@RequestParam("userName") String userName, ModelMap modelMap) {
		modelMap.addAttribute("userName", userName);
		return "helloword";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createStudent(@ModelAttribute("user") User user) {
		System.out.println(user);
		return "helloword";
	}
}
