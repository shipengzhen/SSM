package com.bdqn.smbms.service;

import java.util.List;

import com.bdqn.smbms.entity.Role;

/**
 * Service���ɫ�ӿ�
 * @author ʩ����
 *
 */
public interface IRoleService {

	/**
	 * ��ѯ���еĽ�ɫ
	 * @return List<Role>
	 * @throws Exception 
	 */
	List<Role> findRoles();
}
