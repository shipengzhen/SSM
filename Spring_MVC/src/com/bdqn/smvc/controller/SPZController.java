package com.bdqn.smvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPZController {

	private Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/spz")//萩箔議url
	public String spz(){
		System.out.println("hello,SpringMVC!");
		logger.info("hello,SpringMVC!！！！！！！！！！！");
		return "spz";
	}
}
