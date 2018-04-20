package com.bdqn.spz.stusystem.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * standard(标准信息表)实体类
 * Wed Nov 01 10:56:03 CST 2017 施鹏振
 */ 
public class Standard{

	//主键id
	private Integer id;

	//标准号
	private String stdNum;

	//中文名字
	private String zhname;

	//版本
	private String version;

	//关键词
	private String keys;

	//发布日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;

	//实施日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date implDate;

	//附件路径
	private String packagePath;

	/**
	 *主键id
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *主键id
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *标准号
	 *@param stdNum
	 */
	public void setStdNum(String stdNum){
		this.stdNum=stdNum;
	}

	/**
	 *标准号
	 *@return String stdNum
	 */
	public String getStdNum(){
		return stdNum;
	}

	/**
	 *中文名字
	 *@param zhname
	 */
	public void setZhname(String zhname){
		this.zhname=zhname;
	}

	/**
	 *中文名字
	 *@return String zhname
	 */
	public String getZhname(){
		return zhname;
	}

	/**
	 *版本
	 *@param version
	 */
	public void setVersion(String version){
		this.version=version;
	}

	/**
	 *版本
	 *@return String version
	 */
	public String getVersion(){
		return version;
	}

	/**
	 *关键词
	 *@param keys
	 */
	public void setKeys(String keys){
		this.keys=keys;
	}

	/**
	 *关键词
	 *@return String keys
	 */
	public String getKeys(){
		return keys;
	}

	/**
	 *发布日期
	 *@param releaseDate
	 */
	public void setReleaseDate(Date releaseDate){
		this.releaseDate=releaseDate;
	}

	/**
	 *发布日期
	 *@return Date releaseDate
	 */
	public Date getReleaseDate(){
		return releaseDate;
	}

	/**
	 *实施日期
	 *@param implDate
	 */
	public void setImplDate(Date implDate){
		this.implDate=implDate;
	}

	/**
	 *实施日期
	 *@return Date implDate
	 */
	public Date getImplDate(){
		return implDate;
	}

	/**
	 *附件路径
	 *@param packagePath
	 */
	public void setPackagePath(String packagePath){
		this.packagePath=packagePath;
	}

	/**
	 *附件路径
	 *@return String packagePath
	 */
	public String getPackagePath(){
		return packagePath;
	}
}

