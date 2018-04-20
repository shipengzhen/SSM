package com.bdqn.app.dao.devuser;

import org.apache.ibatis.annotations.Param;
import com.bdqn.app.pojo.DevUser;

/**
 * 开发者数据连接层接口
 * 
 * @author 施鹏振
 *
 */
public interface IDevUserDao {

	/**
	 * 登录
	 * 
	 * @param devCode
	 * @param devPassword
	 * @return DevUser
	 * @throws Exception
	 */
	DevUser findDevUser(@Param("devCode") String devCode, @Param("devPassword") String devPassword) throws Exception;
}
