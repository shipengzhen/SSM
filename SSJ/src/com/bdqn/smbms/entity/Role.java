package com.bdqn.smbms.entity;

import java.util.Date;
import java.util.List;

/**
 * ��ɫʵ����
 * 
 * @author ʩ����
 *
 */
public class Role {
	private int id;// ��ɫid
	private String roleCode;// ��ɫ����
	private String roleName;// ��ɫ����
	private int createdBy;// ������
	private Date creationDate;// ����ʱ��
	private int modifyBy;// �޸���
	private Date modifyDate;// �޸�ʱ��
	private List<User> users;// �û�����

	/**
	 * �û�����
	 * 
	 * @return List<User>
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * �û�����
	 * 
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * ��ɫid
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * ��ɫid
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ɫ����
	 * 
	 * @return
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * ��ɫ����
	 * 
	 * @param roleCode
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * ��ɫ����
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * ��ɫ����
	 * 
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * ������
	 * 
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * ������
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * �޸���
	 * 
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}

	/**
	 * �޸���
	 * 
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * �޸�ʱ��
	 * 
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * �޸�ʱ��
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
