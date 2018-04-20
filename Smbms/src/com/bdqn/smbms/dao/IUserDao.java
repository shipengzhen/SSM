package com.bdqn.smbms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bdqn.smbms.entity.User;

/**
 * Dao���û��ӿ�
 * @author ʩ����
 *
 */
public interface IUserDao {

	/**
	 * �û���½
	 * @param userName
	 * @param userPassword
	 * @return User
	 * @throws Exception 
	 */
	User doLogin(@Param("userName")String userName,@Param("userPassword")String userPassword) throws Exception;//��ҳģ����ѯ�û���Ϣ
	
	/**
	 * ģ����ѯ�û�����
	 * @param userName
	 * @param userRole
	 * @return int
	 * @throws Exception
	 */
	int findUCount(@Param("userName")String userName,@Param("userRole")int userRole) throws Exception;
	
	/**
	 * ģ����ѯ�û���Ϣ
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<User>
	 * @throws Exception
	 */
	List<User> findUsers(@Param("userName")String userName,@Param("userRole")int userRole,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws Exception;
	
	/**
	 * ����û�
	 * @param user
	 * @param connection
	 * @return int
	 * @throws Exception
	 */
	int addUser(User user) throws Exception;
	
	/**
	 * ͨ���û�Id��ѯ�û���Ϣ
	 * @param userId
	 * @return User
	 * @throws Exception
	 */
	User findUser(int userId)throws Exception;
	
	/**
	 * ͨ���û�id�޸��û���Ϣ
	 * @param user
	 * @return int
	 * @throws Exception
	 */
	int  modifyUser(User user)throws Exception;
	
	/**
	 * �ж��û������Ƿ����
	 * @param userCode
	 * @return int
	 * @throws Exception
	 */
	int findCount(String userCode)throws Exception;
}
