package com.mybatis.entity;

import java.util.List;

/**
 * ���ʵ����
 * @author ʩ����
 *
 */
public class Grade {

	private int gradeId;//���id
	private String gradeName;//�������
	private List<Student> students;//ѧ������
	
	/**
	 * ѧ������
	 * @return
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * ѧ������
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	* ���id
	* @return
	*/
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * ���id
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * �������
	 * @return
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * �������
	 * @param gradeName
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
