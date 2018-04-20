package com.bdqn.spz.ssm.service.impl;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bdqn.spz.ssm.dao.IRoleDao;
import com.bdqn.spz.ssm.pojo.Role;
import com.bdqn.spz.ssm.service.IRoleService;

/**
 * Service层角色实现类
 * @author 施鹏振
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private IRoleDao roleDao;
	
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
