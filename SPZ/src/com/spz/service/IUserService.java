package com.spz.service;

import com.spz.entity.User;

public interface IUserService {

	/**
	 * ��¼
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	User doLogin(String userName,String userPassword);
}
