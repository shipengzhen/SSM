package com.bdqn.spz.jboa.pojo;

/**
 * employee(ְ����)ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class Employee{

	//����(����)
	private String sn;

	//ְλID(���)
	private Integer positionId;
	
	//����ְλ��
	private String positionNameCn;

	//����ID(���)
	private Integer departmentId;
	
	//��������
	private String departmentName;

	//ְ����
	private String name;

	//����
	private String passWord;

	//״̬
	private String status;

	/**
	 *����(����)
	 *@param sn
	 */
	public void setSn(String sn){
		this.sn=sn;
	}

	/**
	 *����(����)
	 *@return String sn
	 */
	public String getSn(){
		return sn;
	}

	/**
	 *ְλID(���)
	 *@param positionId
	 */
	public void setPositionId(Integer positionId){
		this.positionId=positionId;
	}

	/**
	 * ����ְλ��
	 * @return String positionNameCn
	 */
	public String getPositionNameCn() {
		return positionNameCn;
	}

	/**
	 * ����ְλ��
	 * @param positionNameCn
	 */
	public void setPositionNameCn(String positionNameCn) {
		this.positionNameCn = positionNameCn;
	}
	
	/**
	 *ְλID(���)
	 *@return Integer positionId
	 */
	public Integer getPositionId(){
		return positionId;
	}

	/**
	 *����ID(���)
	 *@param departmentId
	 */
	public void setDepartmentId(Integer departmentId){
		this.departmentId=departmentId;
	}

	/**
	 *����ID(���)
	 *@return Integer departmentId
	 */
	public Integer getDepartmentId(){
		return departmentId;
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
	
	/**
	 *ְ����
	 *@param name
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 *ְ����
	 *@return String name
	 */
	public String getName(){
		return name;
	}

	/**
	 *����
	 *@param passWord
	 */
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}

	/**
	 *����
	 *@return String passWord
	 */
	public String getPassWord(){
		return passWord;
	}

	/**
	 *״̬
	 *@param status
	 */
	public void setStatus(String status){
		this.status=status;
	}

	/**
	 *״̬
	 *@return String status
	 */
	public String getStatus(){
		return status;
	}
}

