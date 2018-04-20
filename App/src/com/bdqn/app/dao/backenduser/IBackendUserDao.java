package com.bdqn.app.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import com.bdqn.app.pojo.BackendUser;

/**
 * 管理员Dao层接口
 * @author 施鹏振
 *
 */
public interface IBackendUserDao {

	/**
	 * 管理员登陆
	 * @param userCode
	 * @param userPassword
	 * @return BackendUser
	 * @throws Exception
	 */
	BackendUser findBackendUser(@Param("userCode")String userCode,@Param("userPassword")String userPassword)throws Exception;
}
