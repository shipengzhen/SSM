package com.bdqn.spz.ssm.dao;

import java.util.List;

import com.bdqn.spz.ssm.pojo.Role;

/**
 * Dao层角色接口
 * @author 施鹏振
 *
 */
public interface IRoleDao {

	/**
	 * 查询所有的角色
	 * @return List<Role>
	 * @throws Exception 
	 */
	List<Role> findRoles() throws Exception;
}
