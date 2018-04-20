package com.bdqn.smvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bdqn.smvc.entity.User;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome") // 请求的url
	public String welcome() {
		System.out.println("欢迎");
		return "welcome";
	}

	// 参数传递
//	@RequestMapping(value="/welcome1",method=RequestMethod.GET,params="userName") // 请求的url
//	public String welcome(String userName) {
//		System.out.println("欢迎" + userName);
//		return "welcome";
//	}
	
	// 参数传递
	@RequestMapping("/welcome1") // 请求的url
	// 传递参数1:@RequestParam三个参数:value:参数名,required:是否必须，默认true,default:默认参数名，不建议使用
	public String welcome(@RequestParam(value = "userName", required = false) String userName) {
		System.out.println("欢迎" + userName);
		return "welcome";
	}

	@RequestMapping("/welcome2") // 请求的url
	// 传递参数2:controller to view -(ModelAndView)
	public ModelAndView welcome(String userName, String passWord) {
		System.out.println("欢迎" + userName + "密码" + passWord);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("passWord", passWord);
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping("/welcome3") // 请求的url
	// 传递参数3:controller to view -(Map<String,Object>)
	public String welcome(String userName, Map<String, Object> maps) {
		System.out.println("欢迎Map" + userName);
		maps.put("userName", userName);
		return "welcome";
	}

	//@ModelAttribute//放在想要放到数据模型中的值前面
	//@SessionAttributes//放在想要放到HttpSession中的值前面
	
	@RequestMapping("/welcome4") // 请求的url
	// 传递参数3:controller to view -(Map<String,Object>)
	public String welcome(String userName, Model model) {
		System.out.println("欢迎Model" + userName);
		model.addAttribute("username", userName);
		/**
		 * 默认使用对象的类型作为key： model.addAttribute("string", userName)
		 * model.addAttribute("user", new User())
		 */
		model.addAttribute(userName);
		User user = new User();
		user.setUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute(user);
		return "welcome";
	}

	public String welcome(@ModelAttribute("userName") String userName, @ModelAttribute("user") User user) {
		System.out.println("欢迎Model" + userName);
		return "welcome";
	}

	@RequestMapping("/welcome5") // 请求的url
	public String welcome(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("欢迎welcome5");
		request.getParameter("userName");
		return "welcome";
	}
}
