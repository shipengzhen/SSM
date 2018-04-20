package com.bdqn.smbms.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * �û�ʵ����
 * 
 * @author ʩ����
 *
 */
public class User {

	private int id;// �û�id
	
	@NotEmpty(message = "�û����벻��Ϊ��")
	private String userCode;// �û�����

	@NotEmpty(message = "�û����Ʋ���Ϊ��")
	private String userName;// �û�����

	@NotNull(message = "���벻��Ϊ��")
	@Length(min = 6, max = 10, message = "�û����볤��Ϊ6-10")
	private String userPassword;// �û�����

	private int gender;// �Ա�(1:Ů�� 2:��)

	@Past(message = "������һ����ȥ��ʱ��")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JSONField(format = "yyyy-MM-dd")
	private Date birthday;// ��������

	private String phone;// �ֻ�

	private String address;// ��ַ

	private int userRole;// �û���ɫid

	private int createdBy;// �����ߣ�userId��

	private Date creationDate;// ����ʱ��

	private int modifyBy;// ������(userId)

	private Date modifyDate;// ����ʱ��

	private String idPicPath;// ֤����

	/**
	 * �û�id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * �û�id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * �û�����
	 * 
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * �û�����
	 * 
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * �û�����
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �û�����
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �û�����
	 * 
	 * @return
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * �û�����
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * �Ա�(1:Ů�� 2:��)
	 * 
	 * @return
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * �Ա�(1:Ů�� 2:��)
	 * 
	 * @param gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * ��������
	 * 
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * �ֻ�
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * �ֻ�
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * ��ַ
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * ��ַ
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * �û���ɫid
	 * 
	 * @return
	 */
	public int getUserRole() {
		return userRole;
	}

	/**
	 * �û���ɫid
	 * 
	 * @param userRole
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	/**
	 * �����ߣ�userId��
	 * 
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * �����ߣ�userId��
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * ������(userId)
	 * 
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}

	/**
	 * ������(userId)
	 * 
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * ֤����
	 * 
	 * @return
	 */
	public String getIdPicPath() {
		return idPicPath;
	}

	/**
	 * ֤����
	 * 
	 * @param idPicPath
	 */
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
}
