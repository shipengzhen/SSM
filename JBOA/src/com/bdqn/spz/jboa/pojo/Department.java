package com.bdqn.spz.jboa.pojo;

/**
 * department(部门表)实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class Department{

	//部门编号(主键)
	private Integer id;

	//部门名
	private String name;

	/**
	 *部门编号(主键)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *部门编号(主键)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *部门名
	 *@param name
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 *部门名
	 *@return String name
	 */
	public String getName(){
		return name;
	}
}

