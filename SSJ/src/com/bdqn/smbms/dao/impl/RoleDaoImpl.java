package com.bdqn.smbms.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.bdqn.smbms.dao.IRoleDao;
import com.bdqn.smbms.entity.Role;
import com.bdqn.smbms.util.BaseDao;

/**
 * Dao���ɫʵ����
 * 
 * @author ʩ����
 *
 */
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	// ��ѯ���еĽ�ɫ
	@Override
	public List<Role> findRoles() throws Exception {
		String sql = "select id,roleName from Role";
		return getList(Role.class, sql);
	}

}
