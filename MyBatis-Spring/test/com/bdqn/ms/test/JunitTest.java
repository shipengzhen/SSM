package com.bdqn.ms.test;

import org.junit.Test;
import com.bdqn.ms.entity.Grade;
import com.bdqn.ms.entity.Result;
import com.bdqn.ms.entity.Student;
import com.bdqn.ms.service.IGradeService;
import com.bdqn.ms.service.IResultService;
import com.bdqn.ms.service.IStudentService;
import com.bdqn.ms.util.SpringUtil;

public class JunitTest {

	private IGradeService gradeService=(IGradeService)SpringUtil.getObject("GradeServiceImpl");
	private IStudentService studentService=(IStudentService)SpringUtil.getObject("StudentServiceImpl");
	private IResultService resultService=(IResultService)SpringUtil.getObject("ResultServiceImpl");
	
	//查询全部年纪
	@Test
	public void getAllGrades(){
		for (Grade grade: gradeService.getAllGrades()) {
			System.out.println("年纪ID:>"+grade.getGradeId()+"\t年纪名称:"+grade.getGradeName());
		}
	}
	
	//通过学生姓名模糊查询某个年纪的学生信息
	@Test
	public void getStudents(){
		for (Student student:studentService.getStudents(1,"李")) {
			System.out.println("学生学号:"+student.getStudentNo()+"\t学生姓名:"+student.getStudentName()+"\t性别:"+student.getSex());
		}
	}
	
	//通过学号查询学生成绩
	@Test
	public void getResults(){
		Result result=resultService.getResults(10000);
		System.out.println("学号:"+result.getStudentNo()+"\t成绩:"+result.getStudentResult());
	}
	
	public static void main(String[] args) {
		new JunitTest().getResults();
	}
}
