package com.bdqn.smbms.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdqn.smbms.dao.IRoleDao;
import com.bdqn.smbms.entity.Role;
import com.bdqn.smbms.service.IRoleService;

/**
 * Service层角色实现类
 * 
 * @author 施鹏振
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private IRoleDao roleDao;

	// 查询所有的角色
	@Override
	public List<Role> findRoles() {
		List<Role> roles = new ArrayList<Role>();
		try {
			roles = roleDao.findRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
