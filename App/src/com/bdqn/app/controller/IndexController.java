package com.bdqn.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.app.tools.Properties;

@RequestMapping
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return Properties.getString("page", "index");
	}
}
