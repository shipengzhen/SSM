package com.bdqn.ms.entity;

import java.sql.Date;

/**
 * 成绩实体类
 * @author 施鹏振
 *
 */
public class Result {
	
	//学号
	private int studentNo;
	//科目编号
	private int subjectNo;
	//学生成绩
	private int studentResult;
	//考试时间
	private Date examDate;
	/**
	 * 学号
	 * @return
	 */
	public int getStudentNo() {
		return studentNo;
	}
	/**
	 * 学号
	 * @param studentNo
	 */
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	/**
	 * 科目编号
	 * @return
	 */
	public int getSubjectNo() {
		return subjectNo;
	}
	/**
	 * 科目编号
	 * @param subjectNo
	 */
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	/**
	 * 学生成绩
	 * @return
	 */
	public int getStudentResult() {
		return studentResult;
	}
	/**
	 * 学生成绩
	 * @param studentResult
	 */
	public void setStudentResult(int studentResult) {
		this.studentResult = studentResult;
	}
	/**
	 * 考试时间
	 * @return
	 */
	public Date getExamDate() {
		return examDate;
	}
	/**
	 * 考试时间
	 * @param examDate
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
}
