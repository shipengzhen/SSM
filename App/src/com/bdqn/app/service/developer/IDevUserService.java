package com.bdqn.app.service.developer;

import com.bdqn.app.pojo.DevUser;

/**
 * å¼?å‘è?…ä¸šåŠ¡é?»è¾‘æ¥å£
 * 
 * @author æ–½é¹æŒ?
 *
 */
public interface IDevUserService {

	/**
	 * ç™»å½•
	 * 
	 * @param devCode
	 * @param devPassword
	 * @return DevUser
	 */
	DevUser doLogin(String devCode, String devPassword);
}
