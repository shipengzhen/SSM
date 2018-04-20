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

	@RequestMapping("/welcome") // �����url
	public String welcome() {
		System.out.println("��ӭ");
		return "welcome";
	}

	// ��������
//	@RequestMapping(value="/welcome1",method=RequestMethod.GET,params="userName") // �����url
//	public String welcome(String userName) {
//		System.out.println("��ӭ" + userName);
//		return "welcome";
//	}
	
	// ��������
	@RequestMapping("/welcome1") // �����url
	// ���ݲ���1:@RequestParam��������:value:������,required:�Ƿ���룬Ĭ��true,default:Ĭ�ϲ�������������ʹ��
	public String welcome(@RequestParam(value = "userName", required = false) String userName) {
		System.out.println("��ӭ" + userName);
		return "welcome";
	}

	@RequestMapping("/welcome2") // �����url
	// ���ݲ���2:controller to view -(ModelAndView)
	public ModelAndView welcome(String userName, String passWord) {
		System.out.println("��ӭ" + userName + "����" + passWord);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("passWord", passWord);
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping("/welcome3") // �����url
	// ���ݲ���3:controller to view -(Map<String,Object>)
	public String welcome(String userName, Map<String, Object> maps) {
		System.out.println("��ӭMap" + userName);
		maps.put("userName", userName);
		return "welcome";
	}

	//@ModelAttribute//������Ҫ�ŵ�����ģ���е�ֵǰ��
	//@SessionAttributes//������Ҫ�ŵ�HttpSession�е�ֵǰ��
	
	@RequestMapping("/welcome4") // �����url
	// ���ݲ���3:controller to view -(Map<String,Object>)
	public String welcome(String userName, Model model) {
		System.out.println("��ӭModel" + userName);
		model.addAttribute("username", userName);
		/**
		 * Ĭ��ʹ�ö����������Ϊkey�� model.addAttribute("string", userName)
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
		System.out.println("��ӭModel" + userName);
		return "welcome";
	}

	@RequestMapping("/welcome5") // �����url
	public String welcome(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("��ӭwelcome5");
		request.getParameter("userName");
		return "welcome";
	}
}
