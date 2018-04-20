package com.bdqn.app.service.developer;
import com.bdqn.app.pojo.BackendUser;

/**
 * 管理员Service接口
 * @author 施鹏振
 *
 */
public interface IBackendUserService {

	/**
	 * 管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return BackendUser
	 */
	BackendUser doLogin(String userCode,String userPassword);
}
