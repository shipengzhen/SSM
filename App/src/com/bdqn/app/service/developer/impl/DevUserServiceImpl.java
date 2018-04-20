package com.bdqn.app.service.developer.impl;

import com.bdqn.app.dao.devuser.IDevUserDao;
import com.bdqn.app.pojo.DevUser;
import com.bdqn.app.service.developer.IDevUserService;

/**
 * ������ҵ���߼�ʵ����
 * @author ʩ����
 *
 */
public class DevUserServiceImpl implements IDevUserService {

	//Dao�����
	private IDevUserDao developerDao;
	
	
	public IDevUserDao getDeveloperDao() {
		return developerDao;
	}


	public void setDeveloperDao(IDevUserDao developerDao) {
		this.developerDao = developerDao;
	}


	//��¼
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
