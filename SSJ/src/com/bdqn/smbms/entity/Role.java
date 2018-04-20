package com.bdqn.smbms.entity;

import java.util.Date;
import java.util.List;

/**
 * 角色实体类
 * 
 * @author 施鹏振
 *
 */
public class Role {
	private int id;// 角色id
	private String roleCode;// 角色编码
	private String roleName;// 角色名称
	private int createdBy;// 创建者
	private Date creationDate;// 创建时间
	private int modifyBy;// 修改者
	private Date modifyDate;// 修改时间
	private List<User> users;// 用户集合

	/**
	 * 用户集合
	 * 
	 * @return List<User>
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * 用户集合
	 * 
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * 角色id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 角色id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 角色编码
	 * 
	 * @return
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * 角色编码
	 * 
	 * @param roleCode
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * 角色名称
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名称
	 * 
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 创建者
	 * 
	 * @return
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * 创建者
	 * 
	 * @param createdBy
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * 创建时间
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 修改者
	 * 
	 * @return
	 */
	public int getModifyBy() {
		return modifyBy;
	}

	/**
	 * 修改者
	 * 
	 * @param modifyBy
	 */
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * 修改时间
	 * 
	 * @return
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * 修改时间
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
