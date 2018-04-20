package com.bdqn.smbms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bdqn.smbms.entity.Provider;

/**
 * Dao�㹩Ӧ�̽ӿ�
 * @author ʩ����
 *
 */
public interface IProviderDao {
	
	/**
	 * ģ����ѯ��Ӧ������
	 * @param proCode
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	int findPCount(@Param("proCode")String proCode,@Param("proName")String proName) throws Exception;
	
	/**
	 * ģ����ѯ��Ӧ��
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<Provider>
	 * @throws Exception
	 */
	List<Provider> findProviders(@Param("proCode")String proCode,@Param("proName")String proName,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws Exception;
	
	/**
	 * ��ӹ�Ӧ��
	 * @param provider
	 * @param connection
	 * @return int
	 * @throws Exception
	 */
	int addUser(Provider provider) throws Exception;
	
	/**
	 * ͨ����Ӧ��Id��ѯ��Ӧ����Ϣ
	 * @param providerId
	 * @return Provider
	 * @throws Exception
	 */
	Provider findProvider(int providerId) throws Exception;
	
	/**
	 * ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
	 * @param provider
	 * @return int
	 * @throws Exception
	 */
	int  modifyProvider(Provider provider)throws Exception;
}
