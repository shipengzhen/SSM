package com.bdqn.smbms.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.bdqn.smbms.dao.IRoleDao;
import com.bdqn.smbms.entity.Role;
import com.bdqn.smbms.util.BaseDao;

/**
 * Dao层角色实现类
 * 
 * @author 施鹏振
 *
 */
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	// 查询所有的角色
	@Override
	public List<Role> findRoles() throws Exception {
		String sql = "select id,roleName from Role";
		return getList(Role.class, sql);
	}

}
