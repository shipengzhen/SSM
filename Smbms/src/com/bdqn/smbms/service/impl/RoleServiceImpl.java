package com.bdqn.smbms.service.impl;


import java.util.ArrayList;
import java.util.List;
import com.bdqn.smbms.dao.IRoleDao;
import com.bdqn.smbms.entity.Role;
import com.bdqn.smbms.service.IRoleService;

/**
 * Service���ɫʵ����
 * @author ʩ����
 *
 */
public class RoleServiceImpl implements IRoleService {

	private IRoleDao roleDao;//dao���ɫ�ӿ�
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	//��ѯ���еĽ�ɫ
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
