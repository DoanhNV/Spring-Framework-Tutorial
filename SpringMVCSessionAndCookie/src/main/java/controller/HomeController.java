package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import entity.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String loadHomePage(HttpServletRequest servletRequest) {
		/*
		 * servletRequest.getSession().setAttribute("user", new User("DoanhNV",
		 * "admin123"));
		 */
		return "home";
	}

	@RequestMapping("/profile")
	public String loadProfile(@SessionAttribute(name = "user", required = false) User user) {
		System.out.println("user:" + user);
		return "";
	}

	@RequestMapping("/login")
	public String login(HttpServletResponse servletResponse) {
		byte[] userNameIncode = Base64Utils.encode(new String("DoanhNV").getBytes());
		Cookie cookie = new Cookie("userName", new String(userNameIncode));
		cookie.setMaxAge(30);
		servletResponse.addCookie(cookie);
		return "";
	}
	
	
	@RequestMapping("/user")
	public String loadUserPage(@CookieValue(value = "userName", required = false) String userName) {
		System.out.println("userName encode: " + userName);
		userName = userName != null ?  new String(Base64Utils.decode(userName.getBytes())) : userName;
		System.out.println("userName: " + userName);
		return "";
	}

}
