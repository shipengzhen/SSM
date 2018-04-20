package com.bdqn.ms.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bdqn.ms.dao.IStudentDao;
import com.bdqn.ms.entity.Student;

/**
 *  Dao��ѧ��ʵ����
 * @author ʩ����
 *
 */
public class StudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao {

	/**
	 * ͨ��ѧ������ģ����ѯĳ����͵�ѧ����Ϣ
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudents(int gradeId, String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudents(gradeId, studentName);
	}

}
