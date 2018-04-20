package com.bdqn.smbms.service;

import java.util.List;

import com.bdqn.smbms.entity.User;

/**
 * Service���û��ӿ�
 * 
 * @author ʩ����
 *
 */
public interface IUserService {

	/**
	 * �û���½
	 * 
	 * @param userName
	 * @param userPassword
	 * @return User
	 */
	User doLogin(String userName, String userPassword);

	/**
	 * ģ����ѯ�û�����
	 * 
	 * @param userName
	 * @param userRole
	 * @return int
	 */
	int findUCount(String userName, int userRole);

	/**
	 * ģ����ѯ�û���Ϣ
	 * 
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 */
	List<User> findUsers(String userName, int userRole, int currentPageNo, int pageSize);

	/**
	 * ����û�
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean addUser(User user);

	/**
	 * ͨ���û�Id��ѯ�û���Ϣ
	 * 
	 * @param userId
	 * @return User
	 */
	User findUser(int userId);

	/**
	 * ͨ���û�id�޸��û���Ϣ
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean modifyUser(User user);

	/**
	 * �жϸ��û�����Ƿ����
	 * 
	 * @param userCode
	 * @return boolean
	 */
	boolean userCodeIsExit(String userCode);
	
	/**
	 * ��ѯȫ���û�
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 */
	List<User> findUsers(int currentPageNo, int pageSize);
	
	/**
	 * ����ȫ���û�����
	 * @return
	 */
	int getAllUCount();
}
