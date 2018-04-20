package com.bdqn.smbms.service;

import java.util.List;

import com.bdqn.smbms.entity.Role;

/**
 * Service层角色接口
 * @author 施鹏振
 *
 */
public interface IRoleService {

	/**
	 * 查询所有的角色
	 * @return List<Role>
	 * @throws Exception 
	 */
	List<Role> findRoles();
}
