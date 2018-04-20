package com.bdqn.smbms.service.impl;

import java.util.List;
import com.bdqn.smbms.dao.IUserDao;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.service.IUserService;

/**
 * Service���û�ʵ����
 * @author ʩ����
 *
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;//dao���û��ӿ�
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	//�û���¼
	@Override
	public User doLogin(String userName, String userPassword) {
		User user=null;
		try {
			user=userDao.doLogin(userName, userPassword);
			//ƥ������
			if(user!=null){
				if(!user.getUserPassword().equals(userPassword)){
					user = null;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//ģ����ѯ�û�����
	@Override
	public int findUCount(String userName, int userRole){
		int count=0;
		try {
			count=userDao.findUCount(userName, userRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//ģ����ѯ�û���Ϣ
	@Override
	public List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize){
		List<User> users=null;
		try {
			users=userDao.findUsers(userName, userRole, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	//����û���Ϣ
	@Override
	public boolean addUser(User user) {
		int count=0;
		boolean b=false;
		try {
			count=userDao.addUser(user);
			if (count>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//ͨ���û�Id��ѯ�û���Ϣ
	@Override
	public User findUser(int userId) {
		User user=null;
		try {
			user=userDao.findUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//ͨ���û�id�޸��û���Ϣ
	@Override
	public boolean modifyUser(User user) {
		boolean b=false;
		try {
			if (userDao.modifyUser(user)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//�жϸ��û�����Ƿ����
	@Override
	public boolean userCodeIsExit(String userCode) {
		boolean b=true;
		try {
			if (userDao.findCount(userCode)>0) {
				b=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
