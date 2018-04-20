package com.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import com.mybatis.dao.IStudentDao;
import com.mybatis.entity.Student;
import com.mybatis.util.MyBatisUtil;

public class StudentDaoImpl extends MyBatisUtil implements IStudentDao {

	/**
	 * ��ѯѧ������
	 * @return int
	 */
	@Override
	public int count() {
		//return getSqlSession().selectOne("com.mybatis.dao.IStudentDao.count");
		return getSqlSession().getMapper(IStudentDao.class).count();
	}

	/**
	 * ��ѯȫ��ѧ����Ϣ
	 * @return List<Student>
	 */
	@Override
	public List<Student> studentList() {
		return getSqlSession().getMapper(IStudentDao.class).studentList();
	}

	/**
	 * ͨ��ѧ��������ѯѧ����Ϣ
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentName(String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentName(studentName);
	}

	/**
	 * ͨ��ѧ��������ѯѧ����Ϣʹ��Map����
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentNameMap(Map<String, String> studentMap) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentNameMap(studentMap);
	}

	/**
	 *ʹ��resultMap��ѯȫ��ѧ����Ϣ
	 * @return List<Student>
	 */
	@Override
	public List<Student> getMapStudentName() {
		return getSqlSession().getMapper(IStudentDao.class).getMapStudentName();
	}

	/**
	 * ģ����ѯѧ����Ϣ,����ѧ������
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentList(String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentList(studentName);
	}

	/**
	 * ģ����ѯѧ����Ϣ,����ѧ�����������id ʹ�� where-if
	 * @param studentName
	 * @param gradeId
	 * @return
	 */
	@Override
	public List<Student> getStudents(String studentName, int gradeId) {
		return getSqlSession().getMapper(IStudentDao.class).getStudents(studentName, gradeId);
	}

	/**
	 * ͨ��ѧ���޸�ѧ��������Ϣ,ʹ��set-if
	 * @param studentName
	 * @param sex
	 * @return
	 */
	@Override
	public int updateStudent(String studentName, String sex, int studentNo) {
		return getSqlSession().getMapper(IStudentDao.class).updateStudent(studentName, sex, studentNo);
	}

	/**
	 * ����ѧ����Ϣͨ��,trim-choose
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
	 * ͨ�������ѯѧ����Ϣ
	 * @param studentNames
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentsArray(int[] studentNos) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentsArray(studentNos);
	}

	/**
	 * ͨ��List<ѧ��>���������h��ѧ����Ϣ
	 * @param studentNo
	 * @return int
	 */
	@Override
	public int deleteStudentList(List<Integer> studentNos) {
		return getSqlSession().getMapper(IStudentDao.class).deleteStudentList(studentNos);
	}

	/**
	 * ͨ��ѧ���޸�ѧ��������Ϣ,ʹ��set-if(��������)
	 * @param student
	 * @return int
	 */
	@Override
	public int updateStudent2(Student student) {
		return getSqlSession().getMapper(IStudentDao.class).updateStudent2(student);	
	}

	/**
	 * ͨ��Map���ϲ�ѯѧ����Ϣ
	 * @param students
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudentsMap(Map<String, List<Integer>> students) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentsMap(students);
	}
	
	/**
	 * ��ѯѧ����Ϣ(List<Student>)
	 * @param students
	 * @return  List<Student>
	 */
	@Override
	public List<Student> getStudentList2(List<Student> students) {
		return getSqlSession().getMapper(IStudentDao.class).getStudentList2(students);
	}

	/**
	 * ��������ѧ����ϢList<Student>
	 * @param students
	 * @return int
	 */
	@Override
	public int insertStudents(List<Student> students) {
		return getSqlSession().getMapper(IStudentDao.class).insertStudents(students);
	}

	/**
	 * ��ҳ��ѯ����ѧ����Ϣ
	 * @param pageSize
	 * @param currentPageNo
	 * @return
	 */
	@Override
	public List<Student> getAllStudentsPage(int pageSize, int currentPageNo) {
		return getSqlSession().getMapper(IStudentDao.class).getAllStudentsPage(pageSize, currentPageNo);
	}


	

	

	
	

	
	
	

}
