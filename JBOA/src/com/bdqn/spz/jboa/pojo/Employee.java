package com.bdqn.spz.jboa.pojo;

/**
 * employee(职工表)实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class Employee{

	//工号(主键)
	private String sn;

	//职位ID(外键)
	private Integer positionId;
	
	//中文职位名
	private String positionNameCn;

	//部门ID(外键)
	private Integer departmentId;
	
	//部门名称
	private String departmentName;

	//职工名
	private String name;

	//密码
	private String passWord;

	//状态
	private String status;

	/**
	 *工号(主键)
	 *@param sn
	 */
	public void setSn(String sn){
		this.sn=sn;
	}

	/**
	 *工号(主键)
	 *@return String sn
	 */
	public String getSn(){
		return sn;
	}

	/**
	 *职位ID(外键)
	 *@param positionId
	 */
	public void setPositionId(Integer positionId){
		this.positionId=positionId;
	}

	/**
	 * 中文职位名
	 * @return String positionNameCn
	 */
	public String getPositionNameCn() {
		return positionNameCn;
	}

	/**
	 * 中文职位名
	 * @param positionNameCn
	 */
	public void setPositionNameCn(String positionNameCn) {
		this.positionNameCn = positionNameCn;
	}
	
	/**
	 *职位ID(外键)
	 *@return Integer positionId
	 */
	public Integer getPositionId(){
		return positionId;
	}

	/**
	 *部门ID(外键)
	 *@param departmentId
	 */
	public void setDepartmentId(Integer departmentId){
		this.departmentId=departmentId;
	}

	/**
	 *部门ID(外键)
	 *@return Integer departmentId
	 */
	public Integer getDepartmentId(){
		return departmentId;
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
	
	/**
	 *职工名
	 *@param name
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 *职工名
	 *@return String name
	 */
	public String getName(){
		return name;
	}

	/**
	 *密码
	 *@param passWord
	 */
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}

	/**
	 *密码
	 *@return String passWord
	 */
	public String getPassWord(){
		return passWord;
	}

	/**
	 *状态
	 *@param status
	 */
	public void setStatus(String status){
		this.status=status;
	}

	/**
	 *状态
	 *@return String status
	 */
	public String getStatus(){
		return status;
	}
}

