package com.spz.dao.impl;



import com.spz.dao.IUserDao;
import com.spz.entity.User;
import com.spz.util.BaseDao;


public class UserDaoImpl extends BaseDao implements IUserDao  {


	@Override
	public User findUser(String userName, String userPassword)throws Exception{
		String sql="select * from user where userName=? and userPassword=?";
		Object[] objects={userName,userPassword};
		return getObject(User.class, sql, objects);
	}
}
