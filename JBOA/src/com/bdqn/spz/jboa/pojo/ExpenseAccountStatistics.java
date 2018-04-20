package com.bdqn.spz.jboa.pojo;

import java.util.Date;

/**
 * expenseaccountstatistics(报销金额统计表(用于统计))实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class ExpenseAccountStatistics{

	//报销金额统计表编号(主键)
	private Integer id;

	//总金额
	private float totalCount;

	//那年
	private Integer year;

	//那月
	private Integer month;

	//部门编号(外键)
	private Integer departmentId;

	//修改时间
	private Date modifyTime;

	/**
	 *报销金额统计表编号(主键)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *报销金额统计表编号(主键)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *总金额
	 *@param totalCount
	 */
	public void setTotalCount(float totalCount){
		this.totalCount=totalCount;
	}

	/**
	 *总金额
	 *@return float totalCount
	 */
	public float getTotalCount(){
		return totalCount;
	}

	/**
	 *那年
	 *@param year
	 */
	public void setYear(Integer year){
		this.year=year;
	}

	/**
	 *那年
	 *@return Integer year
	 */
	public Integer getYear(){
		return year;
	}

	/**
	 *那月
	 *@param month
	 */
	public void setMonth(Integer month){
		this.month=month;
	}

	/**
	 *那月
	 *@return Integer month
	 */
	public Integer getMonth(){
		return month;
	}

	/**
	 *部门编号(外键)
	 *@param departmentId
	 */
	public void setDepartmentId(Integer departmentId){
		this.departmentId=departmentId;
	}

	/**
	 *部门编号(外键)
	 *@return Integer departmentId
	 */
	public Integer getDepartmentId(){
		return departmentId;
	}

	/**
	 *修改时间
	 *@param modifyTime
	 */
	public void setModifyTime(Date modifyTime){
		this.modifyTime=modifyTime;
	}

	/**
	 *修改时间
	 *@return Date modifyTime
	 */
	public Date getModifyTime(){
		return modifyTime;
	}
}

