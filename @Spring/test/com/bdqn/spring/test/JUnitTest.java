package com.bdqn.spring.test;

import org.junit.Test;

import com.bdqn.spring.service.IGradeService;
import com.bdqn.spring.uitl.SpringUtil;

public class JUnitTest {
	
	IGradeService gradeService=(IGradeService)SpringUtil.getObject("GradeServiceImpl");
	//��������Ϣ
	@Test
	public void addGrade(){
		gradeService.addGrade(2,"S2");;
	}
	
	//��ӡ�꼶��Ϣ
	@Test
	public void printGrade(){
		gradeService.printGrade();
	}
	
	public static void main(String[] args) {
		new JUnitTest().addGrade();
	}
}
