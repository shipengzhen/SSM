package com.bdqn.ms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.ms.entity.Student;

/**
 * Dao层学生接口
 * @author 施鹏振
 *
 */
public interface IStudentDao {

	/**
	 * 通过学生姓名模糊查询某个年纪的学生信息
	 * @param gradeId
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> getStudents(@Param("gradeId")int gradeId,@Param("studentName")String studentName);
}
