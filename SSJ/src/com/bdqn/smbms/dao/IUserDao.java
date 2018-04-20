package com.bdqn.smbms.dao;

import java.util.List;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.util.BaseDao;

/**
 * Dao层用户接口
 * 
 * @author 施鹏振
 *
 */
public interface IUserDao {

	/**
	 * 用户登陆
	 * 
	 * @param userName
	 * @param userPassword
	 * @return User
	 * @throws Exception
	 */
	User doLogin(String userName, String userPassword) throws Exception;// 分页模糊查询用户信息

	/**
	 * 模糊查询用户数量
	 * 
	 * @param userName
	 * @param userRole
	 * @return int
	 * @throws Exception
	 */
	int findUCount(String userName, int userRole) throws Exception;

	/**
	 * 模糊查询用户信息
	 * 
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 * @throws Exception
	 */
	List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @param connection
	 * @return int
	 * @throws Exception
	 */
	int addUser(User user, BaseDao baseDao) throws Exception;

	/**
	 * 通过用户Id查询用户信息
	 * 
	 * @param userId
	 * @return User
	 * @throws Exception
	 */
	User findUser(int userId) throws Exception;

	/**
	 * 通过用户id修改用户信息
	 * 
	 * @param user
	 * @return int
	 * @throws Exception
	 */
	int modifyUser(User user) throws Exception;

	/**
	 * 判断用户编码是否存在
	 * 
	 * @param userCode
	 * @return int
	 * @throws Exception
	 */
	int findCount(String userCode) throws Exception;
	
	/**
	 * 查询全部用户
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 * @throws Exception
	 */
	List<User> findUsers(int currentPageNo, int pageSize)  throws Exception;
	
	/**
	 * 查询全部用户数量
	 * @return
	 */
	int findAllUCount() throws Exception;
}
