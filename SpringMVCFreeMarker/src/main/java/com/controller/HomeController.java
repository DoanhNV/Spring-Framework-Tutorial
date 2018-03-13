package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String loadHomePage(ModelMap modelMap) {
		modelMap.addAttribute("users", intitData());
		return "home";
	}
	
	@RequestMapping("/users")
	public String loadUser(ModelMap modelMap) {
		modelMap.addAttribute("listUser", intitUserList());
		return "home";
	}
	
	@RequestMapping("/directive")
	public String directive(ModelMap modelMap) {
		return "directive";
	}
	
	@RequestMapping("/namespace")
	public String namespace() {
		return "namespace";
	}
	
	
	public List<String> intitData() {
		List<String> users = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			users.add("Hello Doanh");
		}
		return users;
	}
	
	public List<User> intitUserList() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(new User("doanhNV","<br> ngovandoanh@gmail.com"));
		}
		return users;
	}
}
