package com.bdqn.app.service.developer.impl;

import com.bdqn.app.dao.devuser.IDevUserDao;
import com.bdqn.app.pojo.DevUser;
import com.bdqn.app.service.developer.IDevUserService;

/**
 * 开发者业务逻辑实现类
 * @author 施鹏振
 *
 */
public class DevUserServiceImpl implements IDevUserService {

	//Dao层对象
	private IDevUserDao developerDao;
	
	
	public IDevUserDao getDeveloperDao() {
		return developerDao;
	}


	public void setDeveloperDao(IDevUserDao developerDao) {
		this.developerDao = developerDao;
	}


	//登录
	@Override
	public DevUser doLogin(String devCode, String devPassword) {
		DevUser devUser=null;
		try {
			devUser=developerDao.findDevUser(devCode, devPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return devUser;
	}


}
