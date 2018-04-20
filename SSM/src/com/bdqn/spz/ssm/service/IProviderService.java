package com.bdqn.spz.ssm.service;

import java.util.List;

import com.bdqn.spz.ssm.pojo.Provider;

/**
 * Service层供应商接口
 * @author 施鹏振
 *
 */
public interface IProviderService {

	/**
	 * 模糊查询供应商数量
	 * @param proCode
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	int findPCount(String proCode,String proName);
	
	/**
	 * 模糊查询供应商
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<Provider>
	 * @throws Exception
	 */
	List<Provider> findProviders(String proCode,String proName,int currentPageNo,int pageSize);
	
	/**
	 * 添加供应商
	 * @param provider
	 * @param connection
	 * @return boolean
	 */
	boolean addUser(Provider provider);
	
	/**
	 * 通过供应商Id查询供应商信息
	 * @param providerId
	 * @return Provider
	 */
	Provider findProvider(int providerId);
	
	/**
	 * 通过供应商Id修改供应商信息
	 * @param provider
	 * @return boolean
	 */
	boolean modifyProvider(Provider provider);
}
