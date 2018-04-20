package com.bdqn.smbms.service;

import java.util.List;

import com.bdqn.smbms.entity.User;

/**
 * Service层用户接口
 * 
 * @author 施鹏振
 *
 */
public interface IUserService {

	/**
	 * 用户登陆
	 * 
	 * @param userName
	 * @param userPassword
	 * @return User
	 */
	User doLogin(String userName, String userPassword);

	/**
	 * 模糊查询用户数量
	 * 
	 * @param userName
	 * @param userRole
	 * @return int
	 */
	int findUCount(String userName, int userRole);

	/**
	 * 模糊查询用户信息
	 * 
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 */
	List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean addUser(User user);

	/**
	 * 通过用户Id查询用户信息
	 * 
	 * @param userId
	 * @return User
	 */
	User findUser(int userId);

	/**
	 * 通过用户id修改用户信息
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean modifyUser(User user);

	/**
	 * 判断该用户编号是否存在
	 * 
	 * @param userCode
	 * @return boolean
	 */
	boolean userCodeIsExit(String userCode);
	
	/**
	 * 查询全部用户
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 */
	List<User> findUsers(int currentPageNo, int pageSize);
	
	/**
	 * 返回全部用户数量
	 * @return
	 */
	int getAllUCount();
}
