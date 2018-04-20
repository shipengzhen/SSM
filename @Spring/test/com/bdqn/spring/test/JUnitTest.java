package com.bdqn.spring.test;

import org.junit.Test;

import com.bdqn.spring.service.IGradeService;
import com.bdqn.spring.uitl.SpringUtil;

public class JUnitTest {
	
	IGradeService gradeService=(IGradeService)SpringUtil.getObject("GradeServiceImpl");
	//添加年纪信息
	@Test
	public void addGrade(){
		gradeService.addGrade(2,"S2");;
	}
	
	//打印年级信息
	@Test
	public void printGrade(){
		gradeService.printGrade();
	}
	
	public static void main(String[] args) {
		new JUnitTest().addGrade();
	}
}
