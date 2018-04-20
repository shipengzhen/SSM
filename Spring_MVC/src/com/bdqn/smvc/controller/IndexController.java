package com.bdqn.smvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


//陣崙匂:IndexController
public class IndexController extends AbstractController {

	private Logger logger = Logger.getLogger(IndexController.class);
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("hello,SpringMVC!");
		logger.info("hello,SpringMVC!！！！！！！！！！！");
		return new ModelAndView("index");
	}

}
