package com.bdqn.spz.ssm.service;

import java.util.List;

import com.bdqn.spz.ssm.pojo.Role;

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
