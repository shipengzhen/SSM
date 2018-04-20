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
 * Service层用户实现类
 * 
 * @author 施鹏振
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	// 用户登录
	@Override
	public User doLogin(String userName, String userPassword) {
		User user = null;
		try {
			user = userDao.doLogin(userName, userPassword);
			// 匹配密码
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

	// 模糊查询用户数量
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

	// 模糊查询用户信息
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

	// 添加用户信息
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

	// 通过用户Id查询用户信息
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

	// 通过用户id修改用户信息
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

	// 判断该用户编号是否存在
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

	//查询全部用户
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

	//全部用户数量
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
