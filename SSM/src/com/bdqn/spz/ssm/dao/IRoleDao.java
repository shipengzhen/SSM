package com.bdqn.spz.ssm.dao;

import java.util.List;

import com.bdqn.spz.ssm.pojo.Role;

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
