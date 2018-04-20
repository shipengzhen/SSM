package com.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import com.mybatis.dao.IGradeDao;
import com.mybatis.dao.IStudentDao;
import com.mybatis.dao.impl.GradeDaoImpl;
import com.mybatis.dao.impl.StudentDaoImpl;
import com.mybatis.entity.Grade;
import com.mybatis.entity.Student;

/**
 * JUnit测试类
 * @author 施鹏振
 *
 */
public class JUnitTest {
	
	//声明log4j.Logger对象
	private Logger logger = Logger.getLogger(JUnitTest.class);
	
	IStudentDao studentDao=new StudentDaoImpl();
	IGradeDao gradeDao=new GradeDaoImpl();
	
	//查询学生人数
	@Test
	public void count() {
		logger.error(studentDao.count());
		System.out.println(studentDao.count());
	}
	//通过学生姓名查询学生信息
	@Test
	public void studentList() {
		for (Student student : studentDao.studentList()) {
			System.out.println(student.getStudentNo());
		}
	}
	//通过学生姓名查询学生信息
	@Test
	public void getStudentName() {
		for (Student student : studentDao.getStudentName("张三")) {
			System.out.println(student.getStudentName());
		}
	}
	//通过学生姓名查询学生信息使用Map集合
	@Test
	public void getStudentNameMap() {
		Map<String,String> studentMap=new HashMap<String,String>();
		studentMap.put("studentName","张三");
		studentMap.put("gradeId","1");
		for (Student student : studentDao.getStudentNameMap(studentMap)) {
			System.out.println(student.getStudentName());
		}
	}
	//使用resultMap查询全部学生信息
	@Test
	public void getMapStudentName() {
		for (Student student : studentDao.getMapStudentName()) {
			System.out.println(student.getStudentName());
			System.out.println(student.getGrade().getGradeId());
			for (Grade grade: student.getGrades()) {
				System.out.println(grade.getGradeName());
			}
			System.out.println("-------------------------------------");
		}
	}
	//新增年纪
	@Test
	public void insertGrade() {
		Grade grade=new Grade();
		grade.setGradeId(0);
		grade.setGradeName("S3");
		if (gradeDao.insertGrade(grade)>0) {
			System.out.println("新增成功");
		}else{
			System.out.println("新增失败");
		}
	}
	//通过年纪Id修改年纪名称(使用@param注解实现多参数入参)
	@Test
	public void updateGradeName() {
		if (gradeDao.updateGradeName(1,"小鹏")>0) {
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
	//通过年纪Id删除年纪
	@Test
	public void deleteGrade() {
		if (gradeDao.deleteGrade(4)>0) {
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	//模糊查询学生信息,根据学生姓名
	@Test
	public void getStudentList() {
		for (Student student : studentDao.getStudentList("张")) {
			System.out.println(student.getStudentName());
		}
	}
	//模糊查询学生信息,根据学生姓名和年纪id
	@Test
	public void getStudents() {
		IStudentDao studentDao=new StudentDaoImpl();
		for (Student student : studentDao.getStudents("张",1)) {
			System.out.println(student.getStudentName());
		}
	}
	//通过学号修改学生多条信息,使用set-if
	@Test
	public void updateStudent() {
		if (studentDao.updateStudent("小鹏","男",10000)>0) {
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
	//新增学生信息通过,trim-choose
	@Test
	public void insertStudent() {
		if (studentDao.insertStudent(11111,"","","")>0) {
			System.out.println("新增成功");
		}else{
			System.out.println("新增失败");
		}
	}
	
	//通过数组查询学生信息	
	@Test
	public void getStudentsArray(){
		int[] studentNos={10000,10001,10002};
		for (Student student : studentDao.getStudentsArray(studentNos)) {
			System.out.println(student.getStudentName());
		}
	}
	
	//通过List<学号>集合批量刪除学生信息
	@Test
	public void deleteStudentGather(){
		List<Integer> studentNos=new ArrayList<Integer>();
		studentNos.add(10000);
		studentNos.add(10001);
		studentNos.add(10002);
		if (studentDao.deleteStudentList(studentNos)>0) {
			System.out.println("刪除成功");
		}else{
			System.out.println("刪除失败");
		}
	}
	
	//通过学号修改学生多条信息,使用set-if(对象当条件)
	@Test
	public void updateStudent2(){
		Student student=new Student();
		student.setStudentNo(11111);
		student.setSex("男");
		if (studentDao.updateStudent2(student)>0) {
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
	
	//通过Map集合查询学生信息
	@Test
	public void getStudentsMap(){
		List<Integer> studentNos=new ArrayList<Integer>();
		studentNos.add(10000);
		studentNos.add(10001);
		studentNos.add(10002);
		Map<String,List<Integer>> students=new HashMap<String,List<Integer>>();
		students.put("studentNos",studentNos);
		for (Student student : studentDao.getStudentsMap(students)) {
			System.out.println(student.getStudentName());
		}
	}
	
	//查询学生信息(List<Student>)
	@Test
	public void getStudentList2() {
		List<Student> students=new ArrayList<Student>();
		Student student=new Student();
		student.setStudentNo(11111);
		students.add(student);
		for (Student s : studentDao.getStudentList2(students)) {
			System.out.println(s.getStudentName());
		}
	}
	
	//新增多条学生信息List<Student>
	@Test
	public void insertStudents(){
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(22222));
		students.add(new Student(33333));
		if (studentDao.insertStudents(students)>0) {
			System.out.println("新增成功");
		}else{
			System.out.println("新增失败");
		}
	}
	
	//分页查询所有学生信息
	@Test
	public void getAllStudentsPage(){
		for (Student student :studentDao.getAllStudentsPage(0,1)) {//(当前页-1)*页大小,页大小
			System.out.println(student.getStudentNo());
		}
	}
	
	//查询各年级学生信息
	public void getStudent(){
		for (Grade grade :gradeDao.getStudent()) {
			System.out.println(grade.getGradeName());
			for (Student student:grade.getStudents()) {
				System.out.println(student.getStudentName());
			}
			System.out.println("---------------------------------");
		}
	}
	
	public static void main(String[] args) {
		new JUnitTest().getStudent();
	}
}