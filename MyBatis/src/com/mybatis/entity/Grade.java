package com.mybatis.entity;

import java.util.List;

/**
 * 年纪实现类
 * @author 施鹏振
 *
 */
public class Grade {

	private int gradeId;//年纪id
	private String gradeName;//年纪名称
	private List<Student> students;//学生集合
	
	/**
	 * 学生集合
	 * @return
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * 学生集合
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	* 年纪id
	* @return
	*/
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * 年纪id
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * 年纪名称
	 * @return
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * 年纪名称
	 * @param gradeName
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
