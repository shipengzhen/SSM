package com.bdqn.ms.entity;

import java.sql.Date;

/**
 * �ɼ�ʵ����
 * @author ʩ����
 *
 */
public class Result {
	
	//ѧ��
	private int studentNo;
	//��Ŀ���
	private int subjectNo;
	//ѧ���ɼ�
	private int studentResult;
	//����ʱ��
	private Date examDate;
	/**
	 * ѧ��
	 * @return
	 */
	public int getStudentNo() {
		return studentNo;
	}
	/**
	 * ѧ��
	 * @param studentNo
	 */
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	/**
	 * ��Ŀ���
	 * @return
	 */
	public int getSubjectNo() {
		return subjectNo;
	}
	/**
	 * ��Ŀ���
	 * @param subjectNo
	 */
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	/**
	 * ѧ���ɼ�
	 * @return
	 */
	public int getStudentResult() {
		return studentResult;
	}
	/**
	 * ѧ���ɼ�
	 * @param studentResult
	 */
	public void setStudentResult(int studentResult) {
		this.studentResult = studentResult;
	}
	/**
	 * ����ʱ��
	 * @return
	 */
	public Date getExamDate() {
		return examDate;
	}
	/**
	 * ����ʱ��
	 * @param examDate
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
}
