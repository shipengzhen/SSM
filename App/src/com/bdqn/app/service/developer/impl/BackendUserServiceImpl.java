package com.bdqn.app.service.developer.impl;

import com.bdqn.app.dao.backenduser.IBackendUserDao;
import com.bdqn.app.pojo.BackendUser;
import com.bdqn.app.service.developer.IBackendUserService;

/**
 * 管理员Service层实现类
 * @author 施鹏�?
 *
 */
public class BackendUserServiceImpl implements IBackendUserService {

	private IBackendUserDao backendUserDao;

	public IBackendUserDao getBackendUserDao() {
		return backendUserDao;
	}

	public void setBackendUserDao(IBackendUserDao backendUserDao) {
		this.backendUserDao = backendUserDao;
	}

	//管理员登�?
	@Override
	public BackendUser doLogin(String userCode, String userPassword) {
		BackendUser backendUser = null;
		try {
			backendUser = backendUserDao.findBackendUser(userCode, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backendUser;
	}

}
