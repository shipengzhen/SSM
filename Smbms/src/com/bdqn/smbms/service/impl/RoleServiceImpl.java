package com.bdqn.smbms.service.impl;


import java.util.ArrayList;
import java.util.List;
import com.bdqn.smbms.dao.IRoleDao;
import com.bdqn.smbms.entity.Role;
import com.bdqn.smbms.service.IRoleService;

/**
 * Service层角色实现类
 * @author 施鹏振
 *
 */
public class RoleServiceImpl implements IRoleService {

	private IRoleDao roleDao;//dao层角色接口
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	//查询所有的角色
	@Override
	public List<Role> findRoles() {
		List<Role> roles=new ArrayList<Role>();
		try {
			roles=roleDao.findRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
