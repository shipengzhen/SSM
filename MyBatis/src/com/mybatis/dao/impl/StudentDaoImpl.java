package com.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import com.mybatis.dao.IStudentDao;
import com.mybatis.entity.Student;
import com.mybatis.util.MyBatisUtil;

public class StudentDaoImpl extends MyBatisUtil implements IStudentDao {

	/**
	 * 查询学生人数
	 * @return int
	 */
	@Override
	public int count() {
		//return getSqlSession().selectOne("com.mybatis.dao.IStudentDao.count");
		return getSqlSession().getMapper(IStudentDao.class).count();
	}

	/**
	 * 查询全部学生信息
	 * @return List<Student>
	 */
	@Override
	public List<Student> studentList() {
		return getSqlSession().getMapper(IStudentDao.class).studentList();
	}

	/**
	 * 通过学生姓名查询学生信息
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentName(String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentName(studentName);
	}

	/**
	 * 通过学生姓名查询学生信息使用Map集合
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentNameMap(Map<String, String> studentMap) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentNameMap(studentMap);
	}

	/**
	 *使用resultMap查询全部学生信息
	 * @return List<Student>
	 */
	@Override
	public List<Student> getMapStudentName() {
		return getSqlSession().getMapper(IStudentDao.class).getMapStudentName();
	}

	/**
	 * 模糊查询学生信息,根据学生姓名
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentList(String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentList(studentName);
	}

	/**
	 * 模糊查询学生信息,根据学生姓名和年纪id 使用 where-if
	 * @param studentName
	 * @param gradeId
	 * @return
	 */
	@Override
	public List<Student> getStudents(String studentName, int gradeId) {
		return getSqlSession().getMapper(IStudentDao.class).getStudents(studentName, gradeId);
	}

	/**
	 * 通过学号修改学生多条信息,使用set-if
	 * @param studentName
	 * @param sex
	 * @return
	 */
	@Override
	public int updateStudent(String studentName, String sex, int studentNo) {
		return getSqlSession().getMapper(IStudentDao.class).updateStudent(studentName, sex, studentNo);
	}

	/**
	 * 新增学生信息通过,trim-choose
	 * @param studentNo
	 * @param loginPwd
	 * @param studentName
	 * @param sex
	 * @return int
	 */
	@Override
	public int insertStudent(int studentNo, String loginPwd, String studentName, String sex) {
		return getSqlSession().getMapper(IStudentDao.class).insertStudent(studentNo, loginPwd, studentName, sex);
	}

	/**
	 * 通过数组查询学生信息
	 * @param studentNames
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentsArray(int[] studentNos) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentsArray(studentNos);
	}

	/**
	 * 通过List<学号>集合批量刪除学生信息
	 * @param studentNo
	 * @return int
	 */
	@Override
	public int deleteStudentList(List<Integer> studentNos) {
		return getSqlSession().getMapper(IStudentDao.class).deleteStudentList(studentNos);
	}

	/**
	 * 通过学号修改学生多条信息,使用set-if(对象当条件)
	 * @param student
	 * @return int
	 */
	@Override
	public int updateStudent2(Student student) {
		return getSqlSession().getMapper(IStudentDao.class).updateStudent2(student);	
	}

	/**
	 * 通过Map集合查询学生信息
	 * @param students
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentsMap(Map<String, List<Integer>> students) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentsMap(students);
	}
	
	/**
	 * 查询学生信息(List<Student>)
	 * @param students
	 * @return  List<Student>
	 */
	@Override
	public List<Student> getStudentList2(List<Student> students) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentList2(students);
	}

	/**
	 * 新增多条学生信息List<Student>
	 * @param students
	 * @return int
	 */
	@Override
	public int insertStudents(List<Student> students) {
		return getSqlSession().getMapper(IStudentDao.class).insertStudents(students);
	}

	/**
	 * 分页查询所有学生信息
	 * @param pageSize
	 * @param currentPageNo
	 * @return
	 */
	@Override
	public List<Student> getAllStudentsPage(int pageSize, int currentPageNo) {
		return getSqlSession().getMapper(IStudentDao.class).getAllStudentsPage(pageSize, currentPageNo);
	}


	

	

	
	

	
	
	

}
