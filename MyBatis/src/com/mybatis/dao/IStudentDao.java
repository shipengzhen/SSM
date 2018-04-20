package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.entity.Student;

public interface IStudentDao {
	/**
	 * ��ѯѧ������
	 * @return int
	 */
	public int count();
	/**
	 * ��ѯȫ��ѧ����Ϣ
	 * @return List<Student>
	 */
	public List<Student> studentList();
	/**
	 * ͨ��ѧ��������ѯѧ����Ϣ
	 * @return List<Student>
	 */
	public List<Student> getStudentName(String studentName);
	/**
	 * ͨ��ѧ��������ѯѧ����Ϣʹ��Map����
	 * @return List<Student>
	 */
	public List<Student> getStudentNameMap(Map<String, String> studentMap);
	/**
	 *ʹ��resultMap��ѯȫ��ѧ����Ϣ
	 * @return List<Student>
	 */
	public List<Student> getMapStudentName();
	
	/**
	 * ģ����ѯѧ����Ϣ,����ѧ������
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> getStudentList(String studentName);
	
	/**
	 * ģ����ѯѧ����Ϣ,����ѧ�����������id ʹ�� where-if
	 * @param studentName
	 * @param gradeId
	 * @return List<Student>
	 */
	public List<Student> getStudents(@Param("studentName")String studentName,@Param("gradeId")int gradeId);
	
	/**
	 * ͨ��ѧ���޸�ѧ��������Ϣ,ʹ��set-if
	 * @param studentName
	 * @param sex
	 * @return int
	 */
	public int updateStudent(@Param("studentName")String studentName,@Param("sex")String sex,@Param("studentNo")int studentNo);
	
	/**
	 * ����ѧ����Ϣͨ��,trim-choose
	 * @param studentNo
	 * @param loginPwd
	 * @param studentName
	 * @param sex
	 * @return int
	 */
	public int insertStudent(@Param("studentNo")int studentNo,@Param("loginPwd")String loginPwd,@Param("studentName")String studentName,@Param("sex")String sex);
	
	/**
	 * ͨ�������ѯѧ����Ϣ
	 * @param studentNames
	 * @return List<Student>
	 */
	public List<Student> getStudentsArray(int[] studentNos);
	
	/**
	 * ͨ��List<ѧ��>���������h��ѧ����Ϣ
	 * @param studentNo
	 * @return int
	 */
	public int deleteStudentList(List<Integer> studentNos);
	
	/**
	 * ͨ��ѧ���޸�ѧ��������Ϣ,ʹ��set-if(��������)
	 * @param student
	 * @return int
	 */
	public int updateStudent2(Student student);
	
	/**
	 * ͨ��Map���ϲ�ѯѧ����Ϣ
	 * @param students
	 * @return List<Student>
	 */
	public List<Student> getStudentsMap(Map<String,List<Integer>> students);
	
	/**
	 * ��ѯѧ����Ϣ(List<Student>)
	 * @param students
	 * @return  List<Student>
	 */
	public List<Student> getStudentList2(List<Student> students);
	
	/**
	 * ��������ѧ����ϢList<Student>
	 * @param students
	 * @return int
	 */
	public int insertStudents(List<Student> students);
	
	/**
	 * ��ҳ��ѯ����ѧ����Ϣ
	 * @param pageSize
	 * @param currentPageNo
	 * @return
	 */
	public List<Student> getAllStudentsPage(@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize);
}
