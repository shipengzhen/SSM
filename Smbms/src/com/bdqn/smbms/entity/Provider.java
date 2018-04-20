package com.bdqn.smbms.entity;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * ��Ӧ�̽ṹʵ����
 * @author ʩ����
 *
 */
public class Provider {
	
	private int id;//��Ӧ��id����
	@NotEmpty(message="��Ӧ�̱��벻��Ϊ��")
	private String proCode;//��Ӧ�̱���
	@NotEmpty(message="��Ӧ�����Ʋ���Ϊ��")
	private String proName;//��Ӧ������
	private String proDesc;//��Ӧ����ϸ����
	@NotEmpty(message="��ϵ�˲���Ϊ��")
	private String proContact;//��Ӧ����ϵ��
	@Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message="��������ȷ��ʽ���ֻ���")
	private String proPhone;//��ϵ�绰
	private String proAddress;//��ַ
	private String proFax;//����
	private int createdBy;//������(userId)
	private Date creationDate;//����ʱ��
	private int modifyBy;//������(userId)
	private Date modifyDate;//����ʱ��
	private String companyLicPicPath;//��ҵӪҵִ��
	private String orgCodePicPath;//��֯��������֤
	/**
	 * ��Ӧ��id����
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * ��Ӧ��id����
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��Ӧ�̱���
	 * @return
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * ��Ӧ�̱���
	 * @param proCode
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	/**
	 * ��Ӧ������
	 * @return
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * ��Ӧ������
	 * @param proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * ��Ӧ����ϸ����
	 * @return
	 */
	public String getProDesc() {
		return proDesc;
	}
	/**
	 * ��Ӧ����ϸ����
	 * @param proDesc
	 */
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	/**
	 * ��Ӧ����ϵ��
	 * @return
	 */
	public String getProContact() {
		return proContact;
	}
	/**
	 * ��Ӧ����ϵ��
	 * @param proContact
	 */
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	/**
	 * ��ϵ�绰
	 * @return
	 */
	public String getProPhone() {
		return proPhone;
	}
	/**
	 * ��ϵ�绰
	 * @param proPhone
	 */
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	/**
	 * ��ַ
	 * @return
	 */
	public String getProAddress() {
		return proAddress;
	}
	/**
	 * ��ַ
	 * @param proAddress
	 */
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	/**
	 * ����
	 * @return
	 */
	public String getProFax() {
		return proFax;
	}
	/**
	 * ����
	 * @param proFax
	 */
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	/**
	 * ������(userId)
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * ������(userId)
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
	 * ������(userId)
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}
	/**
	 * ������(userId)
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * ����ʱ��
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * ����ʱ��
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * ��ҵӪҵִ��
	 * @return
	 */
	public String getCompanyLicPicPath() {
		return companyLicPicPath;
	}
	/**
	 * ��ҵӪҵִ��
	 * @param companyLicPicPath
	 */
	public void setCompanyLicPicPath(String companyLicPicPath) {
		this.companyLicPicPath = companyLicPicPath;
	}
	/**
	 * ��֯��������֤
	 * @return
	 */
	public String getOrgCodePicPath() {
		return orgCodePicPath;
	}
	/**
	 * ��֯��������֤
	 * @param orgCodePicPath
	 */
	public void setOrgCodePicPath(String orgCodePicPath) {
		this.orgCodePicPath = orgCodePicPath;
	}
}
