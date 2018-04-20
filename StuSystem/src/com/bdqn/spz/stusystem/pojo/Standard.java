package com.bdqn.spz.stusystem.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * standard(��׼��Ϣ��)ʵ����
 * Wed Nov 01 10:56:03 CST 2017 ʩ����
 */ 
public class Standard{

	//����id
	private Integer id;

	//��׼��
	private String stdNum;

	//��������
	private String zhname;

	//�汾
	private String version;

	//�ؼ���
	private String keys;

	//��������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;

	//ʵʩ����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date implDate;

	//����·��
	private String packagePath;

	/**
	 *����id
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *����id
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *��׼��
	 *@param stdNum
	 */
	public void setStdNum(String stdNum){
		this.stdNum=stdNum;
	}

	/**
	 *��׼��
	 *@return String stdNum
	 */
	public String getStdNum(){
		return stdNum;
	}

	/**
	 *��������
	 *@param zhname
	 */
	public void setZhname(String zhname){
		this.zhname=zhname;
	}

	/**
	 *��������
	 *@return String zhname
	 */
	public String getZhname(){
		return zhname;
	}

	/**
	 *�汾
	 *@param version
	 */
	public void setVersion(String version){
		this.version=version;
	}

	/**
	 *�汾
	 *@return String version
	 */
	public String getVersion(){
		return version;
	}

	/**
	 *�ؼ���
	 *@param keys
	 */
	public void setKeys(String keys){
		this.keys=keys;
	}

	/**
	 *�ؼ���
	 *@return String keys
	 */
	public String getKeys(){
		return keys;
	}

	/**
	 *��������
	 *@param releaseDate
	 */
	public void setReleaseDate(Date releaseDate){
		this.releaseDate=releaseDate;
	}

	/**
	 *��������
	 *@return Date releaseDate
	 */
	public Date getReleaseDate(){
		return releaseDate;
	}

	/**
	 *ʵʩ����
	 *@param implDate
	 */
	public void setImplDate(Date implDate){
		this.implDate=implDate;
	}

	/**
	 *ʵʩ����
	 *@return Date implDate
	 */
	public Date getImplDate(){
		return implDate;
	}

	/**
	 *����·��
	 *@param packagePath
	 */
	public void setPackagePath(String packagePath){
		this.packagePath=packagePath;
	}

	/**
	 *����·��
	 *@return String packagePath
	 */
	public String getPackagePath(){
		return packagePath;
	}
}

