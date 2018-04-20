package com.bdqn.spz.ssm.pojo;

import java.sql.Date;

/**
 * ����ʵ����
 * @author ʩ����
 *
 */
public class Bill {

	private int id;//����id����
	private String billCode;//�˵�����
	private String productName;//��Ʒ����
	private String productDesc;//��Ʒ����
	private String productUnit;//��Ʒ��λ
	private double productCount;//��Ʒ����
	private double totalPrice;//��Ʒ�ܶ�
	private int isPayment;//�Ƿ�֧��(1��δ֧�� 2����֧��)
	private String createdBy;//�����ߣ�userId��
	private Date creationDate;//����ʱ��
	private String modifyBy;//������(userId)
	private Date modifyDate;//����ʱ��                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	private int providerId;//��Ӧ��ID
	/**
	 * ����id����
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * ����id����
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * �˵�����
	 * @return
	 */
	public String getBillCode() {
		return billCode;
	}
	/**
	 * 
	 * �˵�����
	 * @param billCode
	 */
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	/**
	 * ��Ʒ����
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * ��Ʒ����
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * ��Ʒ����
	 * @return
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * ��Ʒ����
	 * @param productDesc
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * ��Ʒ��λ
	 * @return
	 */
	public String getProductUnit() {
		return productUnit;
	}
	/**
	 * ��Ʒ��λ
	 * @param productUnit
	 */
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	/**
	 * ��Ʒ����
	 * @return
	 */
	public double getProductCount() {
		return productCount;
	}
	/**
	 * ��Ʒ����
	 * @param productCount
	 */
	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}
	/**
	 * ��Ʒ�ܶ�
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * ��Ʒ�ܶ�
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * �Ƿ�֧��(1��δ֧�� 2����֧��)
	 * @return
	 */
	public int getIsPayment() {
		return isPayment;
	}
	/**
	 * �Ƿ�֧��(1��δ֧�� 2����֧��)
	 * @param isPayment
	 */
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	/**
	 * �����ߣ�userId��
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * �����ߣ�userId��
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
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
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * ������(userId)
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy) {
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
	 * ��Ӧ��ID
	 * @return
	 */
	public int getProviderId() {
		return providerId;
	}
	/**
	 * ��Ӧ��ID
	 * @param providerId
	 */
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
}
