package com.bdqn.spz.jboa.pojo;

import java.util.Date;

/**
 * checkresult(审核结果表)实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class CheckResult{

	//审核结果编号(主键)
	private Integer id;

	//报销单编号(外键)
	private Integer claimId;

	//审核时间
	private Date checkTime;

	//审核人工号(外键)
	private String checkSn;

	//审核人名
	private String checkName;

	//审核结果
	private String result;

	//审核意见
	private String comment;

	/**
	 *审核结果编号(主键)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *审核结果编号(主键)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *报销单编号(外键)
	 *@param claimId
	 */
	public void setClaimId(Integer claimId){
		this.claimId=claimId;
	}

	/**
	 *报销单编号(外键)
	 *@return Integer claimId
	 */
	public Integer getClaimId(){
		return claimId;
	}

	/**
	 *审核时间
	 *@param checkTime
	 */
	public void setCheckTime(Date checkTime){
		this.checkTime=checkTime;
	}

	/**
	 *审核时间
	 *@return Date checkTime
	 */
	public Date getCheckTime(){
		return checkTime;
	}

	/**
	 *审核人工号(外键)
	 *@param checkSn
	 */
	public void setCheckSn(String checkSn){
		this.checkSn=checkSn;
	}

	/**
	 *审核人工号(外键)
	 *@return String checkSn
	 */
	public String getCheckSn(){
		return checkSn;
	}

	/**
	 * 审核人名
	 * @return String checkName
	 */
	public String getCheckName() {
		return checkName;
	}

	/**
	 * 审核人名
	 * @param checkName
	 */
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	
	/**
	 *审核结果
	 *@param result
	 */
	public void setResult(String result){
		this.result=result;
	}

	/**
	 *审核结果
	 *@return String result
	 */
	public String getResult(){
		return result;
	}

	/**
	 *审核意见
	 *@param comment
	 */
	public void setComment(String comment){
		this.comment=comment;
	}

	/**
	 *审核意见
	 *@return String comment
	 */
	public String getComment(){
		return comment;
	}
}

