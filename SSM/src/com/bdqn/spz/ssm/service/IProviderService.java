package com.bdqn.spz.ssm.service;

import java.util.List;

import com.bdqn.spz.ssm.pojo.Provider;

/**
 * Service�㹩Ӧ�̽ӿ�
 * @author ʩ����
 *
 */
public interface IProviderService {

	/**
	 * ģ����ѯ��Ӧ������
	 * @param proCode
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	int findPCount(String proCode,String proName);
	
	/**
	 * ģ����ѯ��Ӧ��
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<Provider>
	 * @throws Exception
	 */
	List<Provider> findProviders(String proCode,String proName,int currentPageNo,int pageSize);
	
	/**
	 * ��ӹ�Ӧ��
	 * @param provider
	 * @param connection
	 * @return boolean
	 */
	boolean addUser(Provider provider);
	
	/**
	 * ͨ����Ӧ��Id��ѯ��Ӧ����Ϣ
	 * @param providerId
	 * @return Provider
	 */
	Provider findProvider(int providerId);
	
	/**
	 * ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
	 * @param provider
	 * @return boolean
	 */
	boolean modifyProvider(Provider provider);
}
