package com.bdqn.smbms.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bdqn.smbms.dao.IUserDao;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.service.IUserService;
import com.bdqn.smbms.util.BaseDao;

/**
 * Service���û�ʵ����
 * 
 * @author ʩ����
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	// �û���¼
	@Override
	public User doLogin(String userName, String userPassword) {
		User user = null;
		try {
			user = userDao.doLogin(userName, userPassword);
			// ƥ������
			if (user != null) {
				if (!user.getUserPassword().equals(userPassword)) {
					user = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// ģ����ѯ�û�����
	@Override
	public int findUCount(String userName, int userRole) {
		int count = 0;
		try {
			count = userDao.findUCount(userName, userRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// ģ����ѯ�û���Ϣ
	@Override
	public List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize) {
		List<User> users = null;
		try {
			users = userDao.findUsers(userName, userRole, currentPageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	// ����û���Ϣ
	@Override
	public boolean addUser(User user) {
		BaseDao baseDao = new BaseDao();
		int count = 0;
		boolean b = false;
		try {
			baseDao.setCommit(false);
			count = userDao.addUser(user, baseDao);
			if (count > 0) {
				baseDao.commit();
				b = true;
			} else {
				baseDao.rollback();
			}
		} catch (Exception e) {
			try {
				baseDao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			baseDao.closeConnection();
		}
		return b;
	}

	// ͨ���û�Id��ѯ�û���Ϣ
	@Override
	public User findUser(int userId) {
		User user = null;
		try {
			user = userDao.findUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// ͨ���û�id�޸��û���Ϣ
	@Override
	public boolean modifyUser(User user) {
		boolean b = false;
		try {
			if (userDao.modifyUser(user) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// �жϸ��û�����Ƿ����
	@Override
	public boolean userCodeIsExit(String userCode) {
		boolean b = true;
		try {
			if (userDao.findCount(userCode) > 0) {
				b = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//��ѯȫ���û�
	@Override
	public List<User> findUsers(int currentPageNo, int pageSize) {
		List<User> users=new ArrayList<User>();
		try {
			users=userDao.findUsers((currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	//ȫ���û�����
	@Override
	public int getAllUCount() {
		int count=0;
		try {
			count=userDao.findAllUCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
