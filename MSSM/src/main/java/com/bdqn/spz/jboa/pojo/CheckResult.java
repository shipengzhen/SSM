package com.bdqn.spz.jboa.pojo;

import java.util.Date;

/**
 * checkresult(��˽����)ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class CheckResult{

	//��˽�����(����)
	private Integer id;

	//���������(���)
	private Integer claimId;

	//���ʱ��
	private Date checkTime;

	//����˹���(���)
	private String checkSn;

	//�������
	private String checkName;

	//��˽��
	private String result;

	//������
	private String comment;

	/**
	 *��˽�����(����)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *��˽�����(����)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *���������(���)
	 *@param claimId
	 */
	public void setClaimId(Integer claimId){
		this.claimId=claimId;
	}

	/**
	 *���������(���)
	 *@return Integer claimId
	 */
	public Integer getClaimId(){
		return claimId;
	}

	/**
	 *���ʱ��
	 *@param checkTime
	 */
	public void setCheckTime(Date checkTime){
		this.checkTime=checkTime;
	}

	/**
	 *���ʱ��
	 *@return Date checkTime
	 */
	public Date getCheckTime(){
		return checkTime;
	}

	/**
	 *����˹���(���)
	 *@param checkSn
	 */
	public void setCheckSn(String checkSn){
		this.checkSn=checkSn;
	}

	/**
	 *����˹���(���)
	 *@return String checkSn
	 */
	public String getCheckSn(){
		return checkSn;
	}

	/**
	 * �������
	 * @return String checkName
	 */
	public String getCheckName() {
		return checkName;
	}

	/**
	 * �������
	 * @param checkName
	 */
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	
	/**
	 *��˽��
	 *@param result
	 */
	public void setResult(String result){
		this.result=result;
	}

	/**
	 *��˽��
	 *@return String result
	 */
	public String getResult(){
		return result;
	}

	/**
	 *������
	 *@param comment
	 */
	public void setComment(String comment){
		this.comment=comment;
	}

	/**
	 *������
	 *@return String comment
	 */
	public String getComment(){
		return comment;
	}
}

