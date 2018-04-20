package com.bdqn.ms.service.impl;

import java.util.List;

import com.bdqn.ms.dao.IStudentDao;
import com.bdqn.ms.entity.Student;
import com.bdqn.ms.service.IStudentService;

/**
 *  Service��ѧ��ʵ����
 * @author ʩ����
 *
 */
public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;
	
	
	public IStudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}


	/**
	 * ͨ��ѧ������ģ����ѯĳ����͵�ѧ����Ϣ
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudents(int gradeId, String studentName) {
		
		return studentDao.getStudents(gradeId, studentName);
	}

}
