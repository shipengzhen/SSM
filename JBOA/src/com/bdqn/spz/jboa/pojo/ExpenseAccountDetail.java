package com.bdqn.spz.jboa.pojo;

/**
 * expenseaccountdetail(��������ϸ��)ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class ExpenseAccountDetail{

	//��������ϸ���(����)
	private Integer id;

	//���������(���)
	private Integer mainId;

	//��Ŀ
	private String item;

	//���
	private float account;

	//����˵��
	private String desc;

	/**
	 *��������ϸ���(����)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *��������ϸ���(����)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *���������(���)
	 *@param mainId
	 */
	public void setMainId(Integer mainId){
		this.mainId=mainId;
	}

	/**
	 *���������(���)
	 *@return Integer mainId
	 */
	public Integer getMainId(){
		return mainId;
	}

	/**
	 *��Ŀ
	 *@param item
	 */
	public void setItem(String item){
		this.item=item;
	}

	/**
	 *��Ŀ
	 *@return String item
	 */
	public String getItem(){
		return item;
	}

	/**
	 *���
	 *@param account
	 */
	public void setAccount(float account){
		this.account=account;
	}

	/**
	 *���
	 *@return float account
	 */
	public float getAccount(){
		return account;
	}

	/**
	 *����˵��
	 *@param desc
	 */
	public void setDesc(String desc){
		this.desc=desc;
	}

	/**
	 *����˵��
	 *@return String desc
	 */
	public String getDesc(){
		return desc;
	}
}

