package com.bdqn.smbms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bdqn.smbms.dao.IUserDao;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.util.BaseDao;
import com.bdqn.smbms.util.Properties;

/**
 * Dao层用户实现类
 * 
 * @author 施鹏振
 *
 */
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

	// 用户登陆
	@Override
	public User doLogin(String userName, String userPassword) throws Exception {
		String sql = Properties.getString(IUserDao.class.getName(), "doLogin");
		Object[] objects = { userName, userPassword };
		return getObject(User.class, sql, objects);
	}

	// 模糊查询用户数量
	@Override
	public int findUCount(String userName, int userRole) throws Exception {
		String sql = Properties.getString(IUserDao.class.getName(), "findUCount");
		Object[] objects = { userName, userRole };
		return count(sql, objects);
	}

	// 模糊查询用户信息
	@Override
	public List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
		String sql = Properties.getString(IUserDao.class.getName(), "findUsers");
		Object[] objects = { userName, userRole, (currentPageNo - 1) * pageSize, pageSize };
		return getList(User.class, sql, objects);
	}

	// 新增用户
	@Override
	public int addUser(User user, BaseDao baseDao) throws Exception {
		String sql = "insert  into User values(null,?,?,?,?,?,?,?,?,?,?,null,null,?)";
		Object[] objects = { user.getUserCode(), user.getUserName(), user.getUserPassword(), user.getGender(),
				user.getBirthday(), user.getPhone(), user.getAddress(), user.getUserRole(), user.getCreatedBy(),
				user.getCreationDate(), user.getIdPicPath() };
		return baseDao.exUpdate(sql, objects);
	}

	// 通过用户Id查询用户信息
	@Override
	public User findUser(int userId) throws Exception {
		String sql = "select id,userCode,userName,gender,birthday,phone,address,userRole,idPicPath from User where id=?";
		return getObject(User.class, sql, userId);
	}

	// 修改用户信息
	@Override
	public int modifyUser(User user) throws Exception {
		String sql = "update User set userName=?,gender=?,birthday=?,phone=?,address=?,userRole=? where id=?";
		Object[] objects = { user.getUserName(), user.getGender(), user.getBirthday(), user.getPhone(),
				user.getAddress(), user.getUserRole(), user.getId() };
		return exUpdate(sql, objects);
	}

	// 判断用户编码是否存在
	@Override
	public int findCount(String userCode) throws Exception {
		String sql = "select count(*) from user where userCode=?";
		return count(sql, userCode);
	}

	//查询全部用户
	@Override
	public List<User> findUsers(int currentPageNo, int pageSize) throws Exception {
		System.out.println(currentPageNo);
		System.out.println(pageSize);
		String sql = "select * from user limit ?,?";
		Object[] objects={currentPageNo,pageSize};
		return getList(User.class, sql,objects);
	}

	//查询全部用户数量
	@Override
	public int findAllUCount() throws Exception  {
		String sql = "select count(*) from user";
		return count(sql);
	}
}
