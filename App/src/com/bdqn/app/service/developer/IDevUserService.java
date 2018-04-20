package com.bdqn.app.service.developer;

import com.bdqn.app.pojo.DevUser;

/**
 * �?发�?�业务�?�辑接口
 * 
 * @author 施鹏�?
 *
 */
public interface IDevUserService {

	/**
	 * 登录
	 * 
	 * @param devCode
	 * @param devPassword
	 * @return DevUser
	 */
	DevUser doLogin(String devCode, String devPassword);
}
