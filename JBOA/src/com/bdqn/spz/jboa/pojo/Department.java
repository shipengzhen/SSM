package com.bdqn.spz.jboa.pojo;

/**
 * department(���ű�)ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class Department{

	//���ű��(����)
	private Integer id;

	//������
	private String name;

	/**
	 *���ű��(����)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *���ű��(����)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *������
	 *@param name
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 *������
	 *@return String name
	 */
	public String getName(){
		return name;
	}
}

