package com.bdqn.spz.jboa.pojo;

import java.util.Date;

/**
 * expenseaccountstatistics(�������ͳ�Ʊ�(����ͳ��))ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class ExpenseAccountStatistics{

	//�������ͳ�Ʊ���(����)
	private Integer id;

	//�ܽ��
	private float totalCount;

	//����
	private Integer year;

	//����
	private Integer month;

	//���ű��(���)
	private Integer departmentId;

	//�޸�ʱ��
	private Date modifyTime;

	/**
	 *�������ͳ�Ʊ���(����)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *�������ͳ�Ʊ���(����)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *�ܽ��
	 *@param totalCount
	 */
	public void setTotalCount(float totalCount){
		this.totalCount=totalCount;
	}

	/**
	 *�ܽ��
	 *@return float totalCount
	 */
	public float getTotalCount(){
		return totalCount;
	}

	/**
	 *����
	 *@param year
	 */
	public void setYear(Integer year){
		this.year=year;
	}

	/**
	 *����
	 *@return Integer year
	 */
	public Integer getYear(){
		return year;
	}

	/**
	 *����
	 *@param month
	 */
	public void setMonth(Integer month){
		this.month=month;
	}

	/**
	 *����
	 *@return Integer month
	 */
	public Integer getMonth(){
		return month;
	}

	/**
	 *���ű��(���)
	 *@param departmentId
	 */
	public void setDepartmentId(Integer departmentId){
		this.departmentId=departmentId;
	}

	/**
	 *���ű��(���)
	 *@return Integer departmentId
	 */
	public Integer getDepartmentId(){
		return departmentId;
	}

	/**
	 *�޸�ʱ��
	 *@param modifyTime
	 */
	public void setModifyTime(Date modifyTime){
		this.modifyTime=modifyTime;
	}

	/**
	 *�޸�ʱ��
	 *@return Date modifyTime
	 */
	public Date getModifyTime(){
		return modifyTime;
	}
}

