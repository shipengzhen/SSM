package com.bdqn.smbms.entity;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 供应商结构实体类
 * @author 施鹏振
 *
 */
public class Provider {
	
	private int id;//供应商id主键
	@NotEmpty(message="供应商编码不能为空")
	private String proCode;//供应商编码
	@NotEmpty(message="供应商名称不能为空")
	private String proName;//供应商名称
	private String proDesc;//供应商详细描述
	@NotEmpty(message="联系人不能为空")
	private String proContact;//供应商联系人
	@Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message="请输入正确格式的手机号")
	private String proPhone;//联系电话
	private String proAddress;//地址
	private String proFax;//传真
	private int createdBy;//创建者(userId)
	private Date creationDate;//创建时间
	private int modifyBy;//更新者(userId)
	private Date modifyDate;//更新时间
	private String companyLicPicPath;//企业营业执照
	private String orgCodePicPath;//组织机构代码证
	/**
	 * 供应商id主键
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 供应商id主键
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 供应商编码
	 * @return
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * 供应商编码
	 * @param proCode
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	/**
	 * 供应商名称
	 * @return
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * 供应商名称
	 * @param proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 供应商详细描述
	 * @return
	 */
	public String getProDesc() {
		return proDesc;
	}
	/**
	 * 供应商详细描述
	 * @param proDesc
	 */
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	/**
	 * 供应商联系人
	 * @return
	 */
	public String getProContact() {
		return proContact;
	}
	/**
	 * 供应商联系人
	 * @param proContact
	 */
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	/**
	 * 联系电话
	 * @return
	 */
	public String getProPhone() {
		return proPhone;
	}
	/**
	 * 联系电话
	 * @param proPhone
	 */
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	/**
	 * 地址
	 * @return
	 */
	public String getProAddress() {
		return proAddress;
	}
	/**
	 * 地址
	 * @param proAddress
	 */
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	/**
	 * 传真
	 * @return
	 */
	public String getProFax() {
		return proFax;
	}
	/**
	 * 传真
	 * @param proFax
	 */
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	/**
	 * 创建者(userId)
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * 创建者(userId)
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
	 * 更新者(userId)
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}
	/**
	 * 更新者(userId)
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 更新时间
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * 更新时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 企业营业执照
	 * @return
	 */
	public String getCompanyLicPicPath() {
		return companyLicPicPath;
	}
	/**
	 * 企业营业执照
	 * @param companyLicPicPath
	 */
	public void setCompanyLicPicPath(String companyLicPicPath) {
		this.companyLicPicPath = companyLicPicPath;
	}
	/**
	 * 组织机构代码证
	 * @return
	 */
	public String getOrgCodePicPath() {
		return orgCodePicPath;
	}
	/**
	 * 组织机构代码证
	 * @param orgCodePicPath
	 */
	public void setOrgCodePicPath(String orgCodePicPath) {
		this.orgCodePicPath = orgCodePicPath;
	}
}
