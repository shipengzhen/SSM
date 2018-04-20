package com.bdqn.ms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.ms.entity.Student;

/**
 *  Service��ѧ���ӿ�
 * @author ʩ����
 *
 */
public interface IStudentService {

	/**
	 * ͨ��ѧ������ģ����ѯĳ����͵�ѧ����Ϣ
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> getStudents(@Param("gradeId")int gradeId,@Param("studentName")String studentName);
}
