package com.bdqn.app.service.developer;
import com.bdqn.app.pojo.BackendUser;

/**
 * ����ԱService�ӿ�
 * @author ʩ����
 *
 */
public interface IBackendUserService {

	/**
	 * ����Ա��¼
	 * @param userCode
	 * @param userPassword
	 * @return BackendUser
	 */
	BackendUser doLogin(String userCode,String userPassword);
}
