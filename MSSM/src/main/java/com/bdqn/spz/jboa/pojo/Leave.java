package com.bdqn.spz.jboa.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * leave(请假表)实体类 Mon Oct 23 22:19:20 CST 2017 施鹏振
 */
public class Leave {

	// 请假表编号(主键)
	private Integer id;

	// 职工编号(外键)
	private String employeeSn;

	// 职工名
	private String employeeName;

	// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;

	// 结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

	// 请假天数
	private Integer leaveDay;

	// 请假原因
	private String reason;

	// 状态
	private String status;

	// 请假的类型
	private String leaveType;

	// 待审核人编号
	private String nextCheckSn;

	// 审核意见
	private String approveOpinion;

	// 创建时间
	private Date createTime;

	// 修改时间
	private Date modifyTime;

	// 部门名称
	private String departmentName;

	/**
	 * 请假表编号(主键)
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 请假表编号(主键)
	 * 
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 职工编号(外键)
	 * 
	 * @param employeeSn
	 */
	public void setEmployeeSn(String employeeSn) {
		this.employeeSn = employeeSn;
	}

	/**
	 * 职工编号(外键)
	 * 
	 * @return String employeeSn
	 */
	public String getEmployeeSn() {
		return employeeSn;
	}

	/**
	 * 职工名
	 * 
	 * @return String employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 职工名
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * 开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 开始时间
	 * 
	 * @return Date startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 结束时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 结束时间
	 * 
	 * @return Date endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 请假天数
	 * 
	 * @param leaveDay
	 */
	public void setLeaveDay(Integer leaveDay) {
		this.leaveDay = leaveDay;
	}

	/**
	 * 请假天数
	 * 
	 * @return Integer leaveDay
	 */
	public Integer getLeaveDay() {
		return leaveDay;
	}

	/**
	 * 请假原因
	 * 
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 请假原因
	 * 
	 * @return String reason
	 */
	public String getReason() {
		return reason;
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
	 * 请假的类型
	 * 
	 * @param leaveType
	 */
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * 请假的类型
	 * 
	 * @return String leaveType
	 */
	public String getLeaveType() {
		return leaveType;
	}

	/**
	 * 待审核人编号
	 * 
	 * @param nextCheckSn
	 */
	public void setNextCheckSn(String nextCheckSn) {
		this.nextCheckSn = nextCheckSn;
	}

	/**
	 * 待审核人编号
	 * 
	 * @return String nextCheckSn
	 */
	public String getNextCheckSn() {
		return nextCheckSn;
	}

	/**
	 * 审核意见
	 * 
	 * @param approveOpinion
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	/**
	 * 审核意见
	 * 
	 * @return String approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
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
	 * 部门名称
	 * @return String departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名称
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
