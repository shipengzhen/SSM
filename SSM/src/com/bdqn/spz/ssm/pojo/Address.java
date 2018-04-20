package com.bdqn.spz.ssm.pojo;

import java.sql.Date;

/**
 * 地址实体类
 * @author 施鹏振
 *
 */
public class Address {
	 private int id;//地址id主键
	 private String contact;//联系人姓名
	 private String addressDesc;//收货地址明细
	 private String postCode;//邮编
	 private String tel;//联系人电话
	 private int createdBy;//创建者
	 private Date creationDate;//创建时间
	 private int modifyBy;//修改者
	 private Date modifyDate;//修改时间
	 private int userId;//用户id
	 /**
	  * 地址id主键
	  * @return
	  */
	 public int getId() {
		return id;
	}
	 /**
	  * 地址id主键
	  * @param id
	  */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 *联系人姓名 
	 * @return
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 联系人姓名
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 收货地址明细
	 * @return
	 */
	public String getAddressDesc() {
		return addressDesc;
	}
	/**
	 * 收货地址明细
	 * @param addressDesc
	 */
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	/**
	 * 邮编
	 * @return
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 邮编
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 联系人电话
	 * @return
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 联系人电话
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 创建者
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * 创建者
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * 创建时间
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * 修改者
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}
	/**
	 * 修改者
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 修改时间
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * 修改时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 用户id
	 * @return
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * 用户id
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
