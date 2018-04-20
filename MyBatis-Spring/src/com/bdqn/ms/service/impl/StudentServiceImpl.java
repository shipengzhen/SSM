package com.bdqn.ms.service.impl;

import java.util.List;

import com.bdqn.ms.dao.IStudentDao;
import com.bdqn.ms.entity.Student;
import com.bdqn.ms.service.IStudentService;

/**
 *  Service层学生实现类
 * @author 施鹏振
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
	 * 通过学生姓名模糊查询某个年纪的学生信息
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudents(int gradeId, String studentName) {
		
		return studentDao.getStudents(gradeId, studentName);
	}

}
