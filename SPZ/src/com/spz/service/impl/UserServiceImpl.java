package com.spz.service.impl;

import com.spz.dao.IUserDao;
import com.spz.entity.User;
import com.spz.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User doLogin(String userName, String userPassword) {
		User user=null;
		try {
			user=userDao.findUser(userName, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
