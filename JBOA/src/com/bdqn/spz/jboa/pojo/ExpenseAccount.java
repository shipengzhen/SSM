package com.bdqn.spz.jboa.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * expenseaccount(��������)ʵ���� Mon Oct 23 22:19:20 CST 2017 ʩ����
 */
public class ExpenseAccount {

	// ���������(����)
	private Integer id;

	// ������˹���(���)
	private String nextCheckSn;

	// ���������
	private String nextCheckName;

	// �����˹���(���)
	private String createSn;

	// ��������
	private String createName;

	// ����ʱ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	// ����
	private String event;

	// ����
	private float toatlAccount;

	// ״̬
	private String status;

	// �޸�ʱ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyTime;

	// ���������鼯��
	private List<ExpenseAccountDetail> expenseAccountDetails;

	// ְλ��
	private String positionName;

	// ������
	private String departmentName;
	
	//��������˽������
	private List<CheckResult> checkResults;

	/**
	 * ���������(����)
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ���������(����)
	 * 
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ������˹���(���)
	 * 
	 * @param nextCheckSn
	 */
	public void setNextCheckSn(String nextCheckSn) {
		this.nextCheckSn = nextCheckSn;
	}

	/**
	 * ������˹���(���)
	 * 
	 * @return String nextCheckSn
	 */
	public String getNextCheckSn() {
		return nextCheckSn;
	}

	/**
	 * ���������
	 * 
	 * @return String nextCheckName
	 */
	public String getNextCheckName() {
		return nextCheckName;
	}

	/**
	 * ���������
	 * 
	 * @param nextCheckName
	 */
	public void setNextCheckName(String nextCheckName) {
		this.nextCheckName = nextCheckName;
	}

	/**
	 * �����˹���(���)
	 * 
	 * @param createSn
	 */
	public void setCreateSn(String createSn) {
		this.createSn = createSn;
	}

	/**
	 * �����˹���(���)
	 * 
	 * @return String createSn
	 */
	public String getCreateSn() {
		return createSn;
	}

	/**
	 * ��������
	 * 
	 * @return String createName
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * ��������
	 * 
	 * @param createName
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return Date createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * ����
	 * 
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * ����
	 * 
	 * @return String event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * ����
	 * 
	 * @param toatlAccount
	 */
	public void setToatlAccount(float toatlAccount) {
		this.toatlAccount = toatlAccount;
	}

	/**
	 * ����
	 * 
	 * @return float toatlAccount
	 */
	public float getToatlAccount() {
		return toatlAccount;
	}

	/**
	 * ״̬
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ״̬
	 * 
	 * @return String status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * �޸�ʱ��
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * �޸�ʱ��
	 * 
	 * @return Date modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * ���������鼯��
	 * 
	 * @return List<ExpenseAccountDetail>
	 */
	public List<ExpenseAccountDetail> getExpenseAccountDetails() {
		return expenseAccountDetails;
	}

	/**
	 * ���������鼯��
	 * 
	 * @param expenseAccountDetails
	 */
	public void setExpenseAccountDetails(List<ExpenseAccountDetail> expenseAccountDetails) {
		this.expenseAccountDetails = expenseAccountDetails;
	}

	/**
	 * ְλ��
	 * 
	 * @return String positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * ְλ��
	 * 
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	/**
	 * ������
	 * @return String departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * ������
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/**
	 * ��������˽������
	 * @return List<CheckResult> checkResults
	 */
	public List<CheckResult> getCheckResults() {
		return checkResults;
	}

	/**
	 * ��������˽������
	 * @param checkResults
	 */
	public void setCheckResults(List<CheckResult> checkResults) {
		this.checkResults = checkResults;
	}
}
