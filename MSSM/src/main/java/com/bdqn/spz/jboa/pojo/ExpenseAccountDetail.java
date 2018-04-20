package com.bdqn.spz.jboa.pojo;

/**
 * expenseaccountdetail(报销单明细表)实体类
 * Mon Oct 23 22:19:20 CST 2017 施鹏振
 */ 
public class ExpenseAccountDetail{

	//报销单明细编号(主键)
	private Integer id;

	//报销单编号(外键)
	private Integer mainId;

	//项目
	private String item;

	//金额
	private float account;

	//费用说明
	private String desc;

	/**
	 *报销单明细编号(主键)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *报销单明细编号(主键)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *报销单编号(外键)
	 *@param mainId
	 */
	public void setMainId(Integer mainId){
		this.mainId=mainId;
	}

	/**
	 *报销单编号(外键)
	 *@return Integer mainId
	 */
	public Integer getMainId(){
		return mainId;
	}

	/**
	 *项目
	 *@param item
	 */
	public void setItem(String item){
		this.item=item;
	}

	/**
	 *项目
	 *@return String item
	 */
	public String getItem(){
		return item;
	}

	/**
	 *金额
	 *@param account
	 */
	public void setAccount(float account){
		this.account=account;
	}

	/**
	 *金额
	 *@return float account
	 */
	public float getAccount(){
		return account;
	}

	/**
	 *费用说明
	 *@param desc
	 */
	public void setDesc(String desc){
		this.desc=desc;
	}

	/**
	 *费用说明
	 *@return String desc
	 */
	public String getDesc(){
		return desc;
	}
}

