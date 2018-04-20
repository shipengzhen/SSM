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
	
	//��ѯȫ�����
	@Test
	public void getAllGrades(){
		for (Grade grade: gradeService.getAllGrades()) {
			System.out.println("���ID:>"+grade.getGradeId()+"\t�������:"+grade.getGradeName());
		}
	}
	
	//ͨ��ѧ������ģ����ѯĳ����͵�ѧ����Ϣ
	@Test
	public void getStudents(){
		for (Student student:studentService.getStudents(1,"��")) {
			System.out.println("ѧ��ѧ��:"+student.getStudentNo()+"\tѧ������:"+student.getStudentName()+"\t�Ա�:"+student.getSex());
		}
	}
	
	//ͨ��ѧ�Ų�ѯѧ���ɼ�
	@Test
	public void getResults(){
		Result result=resultService.getResults(10000);
		System.out.println("ѧ��:"+result.getStudentNo()+"\t�ɼ�:"+result.getStudentResult());
	}
	
	public static void main(String[] args) {
		new JunitTest().getResults();
	}
}
