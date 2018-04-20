package com.spz.contrtoller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spz.entity.User;
import com.spz.service.IUserService;

@RequestMapping
public class UserController {

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("/dologin")
	public String doLogin(String userName,String userPassword,HttpSession session) {
		String string = null;
		User user = userService.doLogin(userName, userPassword);
		if (user != null) {
			session.setAttribute("user", user);
			string = "welcome";
		} else {
			string = "redirect:/login.html";// ÷ÿ∂®œÚ
		}
		return string;
	}

	@RequestMapping("/spz{userName}")
	public String spz(@PathVariable String userName){
		System.out.println(userName);
		return "welcome";
	}
}
