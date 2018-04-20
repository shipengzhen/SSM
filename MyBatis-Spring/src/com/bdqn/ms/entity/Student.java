package com.bdqn.ms.entity;

import java.util.Date;
import java.util.List;
/**
 * ѧ��ʵ����
 * @author ʩ����
 *
 */
public class Student {
	private int studentNo;//ѧ��
	private String loginPwd;//����
	private String studentName;//����
	private String sex;//�Ա�
	private int gradeId;//��ͱ��
	private String phone;//��ϵ�绰
	private String address;//��ַ
	private Date bornDate;//��������
	private String email;//�ʼ��˺�
	private String identityCard;//���֤��
	private Grade grade;//�꼶
	private List<Grade> grades;//�꼶����
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
	 * ����
	 * @return
	 */
	public String getLoginPwd() {
		return loginPwd;
	}
	/**
	 * ����
	 * @param loginPwd
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	/**
	 * ����
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * ����
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * �Ա�
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * �Ա�
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * ��ͱ��
	 * @return
	 */
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * ��ͱ��
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * ��ϵ�绰
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * ��ϵ�绰
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * ��ַ
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ��ַ
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * ��������
	 * @return
	 */
	public Date getBornDate() {
		return bornDate;
	}
	/**
	 * ��������
	 * @param bornDate
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	/**
	 * �ʼ��˺�
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * �ʼ��˺�
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ���֤��
	 * @return
	 */
	public String getIdentityCard() {
		return identityCard;
	}
	/**
	 * ���֤��
	 * @param identityCard
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/**
	 * �꼶
	 * @return
	 */
	public Grade getGrade() {
		return grade;
	}
	/**
	 * �꼶
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	/**
	 * �꼶����
	 * @return
	 */
	public List<Grade> getGrades() {
		return grades;
	}
	/**
	 * �꼶����
	 * @param grades
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	/**
	 * ѧ��
	 * @param studentNo
	 */
	public Student(int studentNo) {
		super();
		this.studentNo = studentNo;
	}
	/**
	 * ѧ������
	 * @param studentName
	 */
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}
	public Student() {
		super();
	}
}
