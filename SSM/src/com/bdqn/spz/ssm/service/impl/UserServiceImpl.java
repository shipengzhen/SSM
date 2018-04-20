package com.bdqn.spz.ssm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bdqn.spz.ssm.dao.IUserDao;
import com.bdqn.spz.ssm.pojo.User;
import com.bdqn.spz.ssm.service.IUserService;

/**
 * Service层用户实现类
 * @author 施鹏振
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;
	
	
	//用户登录
	@Override
	public User doLogin(String userName, String userPassword) {
		User user=null;
		try {
			user=userDao.doLogin(userName, userPassword);
			//匹配密码
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

	//模糊查询用户数量
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

	//模糊查询用户信息
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

	//添加用户信息
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

	//通过用户Id查询用户信息
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

	//通过用户id修改用户信息
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

	//判断该用户编号是否存在
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
