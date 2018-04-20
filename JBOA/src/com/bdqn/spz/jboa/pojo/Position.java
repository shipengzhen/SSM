package com.bdqn.spz.jboa.pojo;

/**
 * position(职位表)实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class Position{

	//职位编号(主键)
	private Integer id;

	//中文职位名
	private String nameCn;

	//英文职位名
	private String nameEn;

	/**
	 *职位编号(主键)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *职位编号(主键)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *中文职位名
	 *@param nameCn
	 */
	public void setNameCn(String nameCn){
		this.nameCn=nameCn;
	}

	/**
	 *中文职位名
	 *@return String nameCn
	 */
	public String getNameCn(){
		return nameCn;
	}

	/**
	 *英文职位名
	 *@param nameEn
	 */
	public void setNameEn(String nameEn){
		this.nameEn=nameEn;
	}

	/**
	 *英文职位名
	 *@return String nameEn
	 */
	public String getNameEn(){
		return nameEn;
	}
}

