package com.bdqn.smbms.dao;

import java.util.List;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.util.BaseDao;

/**
 * Dao�㹩Ӧ�̽ӿ�
 * 
 * @author ʩ����
 *
 */
public interface IProviderDao {

	/**
	 * ģ����ѯ��Ӧ������
	 * 
	 * @param proCode
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	int findPCount(String proCode, String proName) throws Exception;

	/**
	 * ģ����ѯ��Ӧ��
	 * 
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<Provider>
	 * @throws Exception
	 */
	List<Provider> findProviders(String proCode, String proName, int currentPageNo, int pageSize) throws Exception;

	/**
	 * ��ӹ�Ӧ��
	 * 
	 * @param provider
	 * @param connection
	 * @return int
	 * @throws Exception
	 */
	int addUser(Provider provider, BaseDao baseDao) throws Exception;

	/**
	 * ͨ����Ӧ��Id��ѯ��Ӧ����Ϣ
	 * 
	 * @param providerId
	 * @return Provider
	 * @throws Exception
	 */
	Provider findProvider(int providerId) throws Exception;

	/**
	 * ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
	 * 
	 * @param provider
	 * @return int
	 * @throws Exception
	 */
	int modifyProvider(Provider provider) throws Exception;
}
