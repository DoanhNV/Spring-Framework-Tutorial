package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String loadHomePage(ModelMap modelMap) {
		modelMap.addAttribute("createUser", new User());
		return "createuser";
	}
}
