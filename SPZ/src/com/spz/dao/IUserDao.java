package com.spz.dao;

import com.spz.entity.User;

public interface IUserDao {

	User findUser(String userName,String userPassword) throws Exception;
}
