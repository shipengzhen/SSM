package com.bdqn.spz.ssm.pojo;

import java.sql.Date;

/**
 * ��ַʵ����
 * @author ʩ����
 *
 */
public class Address {
	 private int id;//��ַid����
	 private String contact;//��ϵ������
	 private String addressDesc;//�ջ���ַ��ϸ
	 private String postCode;//�ʱ�
	 private String tel;//��ϵ�˵绰
	 private int createdBy;//������
	 private Date creationDate;//����ʱ��
	 private int modifyBy;//�޸���
	 private Date modifyDate;//�޸�ʱ��
	 private int userId;//�û�id
	 /**
	  * ��ַid����
	  * @return
	  */
	 public int getId() {
		return id;
	}
	 /**
	  * ��ַid����
	  * @param id
	  */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 *��ϵ������ 
	 * @return
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * ��ϵ������
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * �ջ���ַ��ϸ
	 * @return
	 */
	public String getAddressDesc() {
		return addressDesc;
	}
	/**
	 * �ջ���ַ��ϸ
	 * @param addressDesc
	 */
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	/**
	 * �ʱ�
	 * @return
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * �ʱ�
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * ��ϵ�˵绰
	 * @return
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * ��ϵ�˵绰
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * ������
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * ������
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * ����ʱ��
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * ����ʱ��
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * �޸���
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}
	/**
	 * �޸���
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * �޸�ʱ��
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * �޸�ʱ��
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * �û�id
	 * @return
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * �û�id
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
