package com.bdqn.smbms.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户实体类
 * 
 * @author 施鹏振
 *
 */
public class User {

	private int id;// 用户id
	
	@NotEmpty(message = "用户编码不能为空")
	private String userCode;// 用户编码

	@NotEmpty(message = "用户名称不能为空")
	private String userName;// 用户名称

	@NotNull(message = "密码不能为空")
	@Length(min = 6, max = 10, message = "用户密码长度为6-10")
	private String userPassword;// 用户密码

	private int gender;// 性别(1:女、 2:男)

	@Past(message = "必须是一个过去的时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JSONField(format = "yyyy-MM-dd")
	private Date birthday;// 出生日期

	private String phone;// 手机

	private String address;// 地址

	private int userRole;// 用户角色id

	private int createdBy;// 创建者（userId）

	private Date creationDate;// 创建时间

	private int modifyBy;// 更新者(userId)

	private Date modifyDate;// 更新时间

	private String idPicPath;// 证件照

	/**
	 * 用户id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 用户id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 用户编码
	 * 
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 用户编码
	 * 
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 用户名称
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名称
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户密码
	 * 
	 * @return
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 用户密码
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 性别(1:女、 2:男)
	 * 
	 * @return
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * 性别(1:女、 2:男)
	 * 
	 * @param gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * 出生日期
	 * 
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 出生日期
	 * 
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 手机
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 手机
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 地址
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 用户角色id
	 * 
	 * @return
	 */
	public int getUserRole() {
		return userRole;
	}

	/**
	 * 用户角色id
	 * 
	 * @param userRole
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	/**
	 * 创建者（userId）
	 * 
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * 创建者（userId）
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * 创建时间
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 更新者(userId)
	 * 
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}

	/**
	 * 更新者(userId)
	 * 
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * 更新时间
	 * 
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * 更新时间
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 证件照
	 * 
	 * @return
	 */
	public String getIdPicPath() {
		return idPicPath;
	}

	/**
	 * 证件照
	 * 
	 * @param idPicPath
	 */
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
}
