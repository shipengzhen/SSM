package com.bdqn.spz.jboa.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * expenseaccount(报销单表)实体类 Mon Oct 23 22:19:20 CST 2017 施鹏振
 */
public class ExpenseAccount {

	// 报销单编号(主键)
	private Integer id;

	// 待审核人工号(外键)
	private String nextCheckSn;

	// 待审核人名
	private String nextCheckName;

	// 创建人工号(外键)
	private String createSn;

	// 创建人名
	private String createName;

	// 创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	// 事由
	private String event;

	// 总账
	private float toatlAccount;

	// 状态
	private String status;

	// 修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyTime;

	// 报销单详情集合
	private List<ExpenseAccountDetail> expenseAccountDetails;

	// 职位名
	private String positionName;

	// 部门名
	private String departmentName;
	
	//报销单审核结果集合
	private List<CheckResult> checkResults;

	/**
	 * 报销单编号(主键)
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 报销单编号(主键)
	 * 
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 待审核人工号(外键)
	 * 
	 * @param nextCheckSn
	 */
	public void setNextCheckSn(String nextCheckSn) {
		this.nextCheckSn = nextCheckSn;
	}

	/**
	 * 待审核人工号(外键)
	 * 
	 * @return String nextCheckSn
	 */
	public String getNextCheckSn() {
		return nextCheckSn;
	}

	/**
	 * 待审核人名
	 * 
	 * @return String nextCheckName
	 */
	public String getNextCheckName() {
		return nextCheckName;
	}

	/**
	 * 待审核人名
	 * 
	 * @param nextCheckName
	 */
	public void setNextCheckName(String nextCheckName) {
		this.nextCheckName = nextCheckName;
	}

	/**
	 * 创建人工号(外键)
	 * 
	 * @param createSn
	 */
	public void setCreateSn(String createSn) {
		this.createSn = createSn;
	}

	/**
	 * 创建人工号(外键)
	 * 
	 * @return String createSn
	 */
	public String getCreateSn() {
		return createSn;
	}

	/**
	 * 创建人名
	 * 
	 * @return String createName
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * 创建人名
	 * 
	 * @param createName
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @return Date createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 事由
	 * 
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * 事由
	 * 
	 * @return String event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * 总账
	 * 
	 * @param toatlAccount
	 */
	public void setToatlAccount(float toatlAccount) {
		this.toatlAccount = toatlAccount;
	}

	/**
	 * 总账
	 * 
	 * @return float toatlAccount
	 */
	public float getToatlAccount() {
		return toatlAccount;
	}

	/**
	 * 状态
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 状态
	 * 
	 * @return String status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 修改时间
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 修改时间
	 * 
	 * @return Date modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 报销单详情集合
	 * 
	 * @return List<ExpenseAccountDetail>
	 */
	public List<ExpenseAccountDetail> getExpenseAccountDetails() {
		return expenseAccountDetails;
	}

	/**
	 * 报销单详情集合
	 * 
	 * @param expenseAccountDetails
	 */
	public void setExpenseAccountDetails(List<ExpenseAccountDetail> expenseAccountDetails) {
		this.expenseAccountDetails = expenseAccountDetails;
	}

	/**
	 * 职位名
	 * 
	 * @return String positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * 职位名
	 * 
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	/**
	 * 部门名
	 * @return String departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/**
	 * 报销单审核结果集合
	 * @return List<CheckResult> checkResults
	 */
	public List<CheckResult> getCheckResults() {
		return checkResults;
	}

	/**
	 * 报销单审核结果集合
	 * @param checkResults
	 */
	public void setCheckResults(List<CheckResult> checkResults) {
		this.checkResults = checkResults;
	}
}
