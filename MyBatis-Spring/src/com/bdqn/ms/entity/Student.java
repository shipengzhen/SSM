package com.bdqn.ms.entity;

import java.util.Date;
import java.util.List;
/**
 * 学生实现类
 * @author 施鹏振
 *
 */
public class Student {
	private int studentNo;//学号
	private String loginPwd;//密码
	private String studentName;//姓名
	private String sex;//性别
	private int gradeId;//年纪编号
	private String phone;//联系电话
	private String address;//地址
	private Date bornDate;//出生日期
	private String email;//邮件账号
	private String identityCard;//身份证号
	private Grade grade;//年级
	private List<Grade> grades;//年级集合
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
	 * 密码
	 * @return
	 */
	public String getLoginPwd() {
		return loginPwd;
	}
	/**
	 * 密码
	 * @param loginPwd
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	/**
	 * 姓名
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * 姓名
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * 性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 性别
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 年纪编号
	 * @return
	 */
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * 年纪编号
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * 联系电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 联系电话
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 地址
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 出生日期
	 * @return
	 */
	public Date getBornDate() {
		return bornDate;
	}
	/**
	 * 出生日期
	 * @param bornDate
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	/**
	 * 邮件账号
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 邮件账号
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 身份证号
	 * @return
	 */
	public String getIdentityCard() {
		return identityCard;
	}
	/**
	 * 身份证号
	 * @param identityCard
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/**
	 * 年级
	 * @return
	 */
	public Grade getGrade() {
		return grade;
	}
	/**
	 * 年级
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	/**
	 * 年级集合
	 * @return
	 */
	public List<Grade> getGrades() {
		return grades;
	}
	/**
	 * 年级集合
	 * @param grades
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	/**
	 * 学号
	 * @param studentNo
	 */
	public Student(int studentNo) {
		super();
		this.studentNo = studentNo;
	}
	/**
	 * 学生姓名
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
