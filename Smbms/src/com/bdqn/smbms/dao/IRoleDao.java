package com.bdqn.smbms.dao;

import java.util.List;
import com.bdqn.smbms.entity.Role;

/**
 * Dao���ɫ�ӿ�
 * @author ʩ����
 *
 */
public interface IRoleDao {

	/**
	 * ��ѯ���еĽ�ɫ
	 * @return List<Role>
	 * @throws Exception 
	 */
	List<Role> findRoles() throws Exception;
}
