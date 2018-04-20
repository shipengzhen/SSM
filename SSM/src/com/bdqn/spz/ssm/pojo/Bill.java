package com.bdqn.spz.ssm.pojo;

import java.sql.Date;

/**
 * 订单实体类
 * @author 施鹏振
 *
 */
public class Bill {

	private int id;//订单id主键
	private String billCode;//账单编码
	private String productName;//商品名称
	private String productDesc;//商品描述
	private String productUnit;//商品单位
	private double productCount;//商品数量
	private double totalPrice;//商品总额
	private int isPayment;//是否支付(1：未支付 2：已支付)
	private String createdBy;//创建者（userId）
	private Date creationDate;//创建时间
	private String modifyBy;//更新者(userId)
	private Date modifyDate;//更新时间                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	private int providerId;//供应商ID
	/**
	 * 订单id主键
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 订单id主键
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 账单编码
	 * @return
	 */
	public String getBillCode() {
		return billCode;
	}
	/**
	 * 
	 * 账单编码
	 * @param billCode
	 */
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	/**
	 * 商品名称
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 商品名称
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 商品描述
	 * @return
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * 商品描述
	 * @param productDesc
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * 商品单位
	 * @return
	 */
	public String getProductUnit() {
		return productUnit;
	}
	/**
	 * 商品单位
	 * @param productUnit
	 */
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	/**
	 * 商品数量
	 * @return
	 */
	public double getProductCount() {
		return productCount;
	}
	/**
	 * 商品数量
	 * @param productCount
	 */
	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}
	/**
	 * 商品总额
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 商品总额
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 是否支付(1：未支付 2：已支付)
	 * @return
	 */
	public int getIsPayment() {
		return isPayment;
	}
	/**
	 * 是否支付(1：未支付 2：已支付)
	 * @param isPayment
	 */
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	/**
	 * 创建者（userId）
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 创建者（userId）
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
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
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * 更新者(userId)
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy) {
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
	 * 供应商ID
	 * @return
	 */
	public int getProviderId() {
		return providerId;
	}
	/**
	 * 供应商ID
	 * @param providerId
	 */
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
}
