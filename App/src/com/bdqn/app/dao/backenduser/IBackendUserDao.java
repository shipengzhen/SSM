package com.bdqn.app.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import com.bdqn.app.pojo.BackendUser;

/**
 * ����ԱDao��ӿ�
 * @author ʩ����
 *
 */
public interface IBackendUserDao {

	/**
	 * ����Ա��½
	 * @param userCode
	 * @param userPassword
	 * @return BackendUser
	 * @throws Exception
	 */
	BackendUser findBackendUser(@Param("userCode")String userCode,@Param("userPassword")String userPassword)throws Exception;
}
