package com.bdqn.spz.jboa.pojo;

/**
 * position(ְλ��)ʵ����
 * Mon Oct 23 22:19:20 CST 2017 ʩ����
 */ 
public class Position{

	//ְλ���(����)
	private Integer id;

	//����ְλ��
	private String nameCn;

	//Ӣ��ְλ��
	private String nameEn;

	/**
	 *ְλ���(����)
	 *@param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 *ְλ���(����)
	 *@return Integer id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 *����ְλ��
	 *@param nameCn
	 */
	public void setNameCn(String nameCn){
		this.nameCn=nameCn;
	}

	/**
	 *����ְλ��
	 *@return String nameCn
	 */
	public String getNameCn(){
		return nameCn;
	}

	/**
	 *Ӣ��ְλ��
	 *@param nameEn
	 */
	public void setNameEn(String nameEn){
		this.nameEn=nameEn;
	}

	/**
	 *Ӣ��ְλ��
	 *@return String nameEn
	 */
	public String getNameEn(){
		return nameEn;
	}
}

