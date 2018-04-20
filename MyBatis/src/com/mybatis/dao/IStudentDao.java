package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.entity.Student;

public interface IStudentDao {
	/**
	 * 查询学生人数
	 * @return int
	 */
	public int count();
	/**
	 * 查询全部学生信息
	 * @return List<Student>
	 */
	public List<Student> studentList();
	/**
	 * 通过学生姓名查询学生信息
	 * @return List<Student>
	 */
	public List<Student> getStudentName(String studentName);
	/**
	 * 通过学生姓名查询学生信息使用Map集合
	 * @return List<Student>
	 */
	public List<Student> getStudentNameMap(Map<String, String> studentMap);
	/**
	 *使用resultMap查询全部学生信息
	 * @return List<Student>
	 */
	public List<Student> getMapStudentName();
	
	/**
	 * 模糊查询学生信息,根据学生姓名
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> getStudentList(String studentName);
	
	/**
	 * 模糊查询学生信息,根据学生姓名和年纪id 使用 where-if
	 * @param studentName
	 * @param gradeId
	 * @return List<Student>
	 */
	public List<Student> getStudents(@Param("studentName")String studentName,@Param("gradeId")int gradeId);
	
	/**
	 * 通过学号修改学生多条信息,使用set-if
	 * @param studentName
	 * @param sex
	 * @return int
	 */
	public int updateStudent(@Param("studentName")String studentName,@Param("sex")String sex,@Param("studentNo")int studentNo);
	
	/**
	 * 新增学生信息通过,trim-choose
	 * @param studentNo
	 * @param loginPwd
	 * @param studentName
	 * @param sex
	 * @return int
	 */
	public int insertStudent(@Param("studentNo")int studentNo,@Param("loginPwd")String loginPwd,@Param("studentName")String studentName,@Param("sex")String sex);
	
	/**
	 * 通过数组查询学生信息
	 * @param studentNames
	 * @return List<Student>
	 */
	public List<Student> getStudentsArray(int[] studentNos);
	
	/**
	 * 通过List<学号>集合批量刪除学生信息
	 * @param studentNo
	 * @return int
	 */
	public int deleteStudentList(List<Integer> studentNos);
	
	/**
	 * 通过学号修改学生多条信息,使用set-if(对象当条件)
	 * @param student
	 * @return int
	 */
	public int updateStudent2(Student student);
	
	/**
	 * 通过Map集合查询学生信息
	 * @param students
	 * @return List<Student>
	 */
	public List<Student> getStudentsMap(Map<String,List<Integer>> students);
	
	/**
	 * 查询学生信息(List<Student>)
	 * @param students
	 * @return  List<Student>
	 */
	public List<Student> getStudentList2(List<Student> students);
	
	/**
	 * 新增多条学生信息List<Student>
	 * @param students
	 * @return int
	 */
	public int insertStudents(List<Student> students);
	
	/**
	 * 分页查询所有学生信息
	 * @param pageSize
	 * @param currentPageNo
	 * @return
	 */
	public List<Student> getAllStudentsPage(@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize);
}
