package com.bdqn.ms.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bdqn.ms.dao.IStudentDao;
import com.bdqn.ms.entity.Student;

/**
 *  Dao层学生实现类
 * @author 施鹏振
 *
 */
public class StudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao {

	/**
	 * 通过学生姓名模糊查询某个年纪的学生信息
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	@Override
	public List<Student> getStudents(int gradeId, String studentName) {
		return getSqlSession().getMapper(IStudentDao.class).getStudents(gradeId, studentName);
	}

}
