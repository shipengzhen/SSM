package com.bdqn.spz.jboa.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * leave(��ٱ�)ʵ���� Mon Oct 23 22:19:20 CST 2017 ʩ����
 */
public class Leave {

	// ��ٱ���(����)
	private Integer id;

	// ְ�����(���)
	private String employeeSn;

	// ְ����
	private String employeeName;

	// ��ʼʱ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;

	// ����ʱ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

	// �������
	private Integer leaveDay;

	// ���ԭ��
	private String reason;

	// ״̬
	private String status;

	// ��ٵ�����
	private String leaveType;

	// ������˱��
	private String nextCheckSn;

	// ������
	private String approveOpinion;

	// ����ʱ��
	private Date createTime;

	// �޸�ʱ��
	private Date modifyTime;

	// ��������
	private String departmentName;

	/**
	 * ��ٱ���(����)
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��ٱ���(����)
	 * 
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ְ�����(���)
	 * 
	 * @param employeeSn
	 */
	public void setEmployeeSn(String employeeSn) {
		this.employeeSn = employeeSn;
	}

	/**
	 * ְ�����(���)
	 * 
	 * @return String employeeSn
	 */
	public String getEmployeeSn() {
		return employeeSn;
	}

	/**
	 * ְ����
	 * 
	 * @return String employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * ְ����
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * ��ʼʱ��
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * ��ʼʱ��
	 * 
	 * @return Date startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return Date endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * �������
	 * 
	 * @param leaveDay
	 */
	public void setLeaveDay(Integer leaveDay) {
		this.leaveDay = leaveDay;
	}

	/**
	 * �������
	 * 
	 * @return Integer leaveDay
	 */
	public Integer getLeaveDay() {
		return leaveDay;
	}

	/**
	 * ���ԭ��
	 * 
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * ���ԭ��
	 * 
	 * @return String reason
	 */
	public String getReason() {
		return reason;
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
	 * ��ٵ�����
	 * 
	 * @param leaveType
	 */
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * ��ٵ�����
	 * 
	 * @return String leaveType
	 */
	public String getLeaveType() {
		return leaveType;
	}

	/**
	 * ������˱��
	 * 
	 * @param nextCheckSn
	 */
	public void setNextCheckSn(String nextCheckSn) {
		this.nextCheckSn = nextCheckSn;
	}

	/**
	 * ������˱��
	 * 
	 * @return String nextCheckSn
	 */
	public String getNextCheckSn() {
		return nextCheckSn;
	}

	/**
	 * ������
	 * 
	 * @param approveOpinion
	 */
	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	/**
	 * ������
	 * 
	 * @return String approveOpinion
	 */
	public String getApproveOpinion() {
		return approveOpinion;
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
	 * ��������
	 * @return String departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * ��������
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
