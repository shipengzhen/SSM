package com.bdqn.smbms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bdqn.smbms.entity.Provider;

/**
 * Dao层供应商接口
 * @author 施鹏振
 *
 */
public interface IProviderDao {
	
	/**
	 * 模糊查询供应商数量
	 * @param proCode
	 * @param proName
	 * @return
	 * @throws Exception
	 */
	int findPCount(@Param("proCode")String proCode,@Param("proName")String proName) throws Exception;
	
	/**
	 * 模糊查询供应商
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<Provider>
	 * @throws Exception
	 */
	List<Provider> findProviders(@Param("proCode")String proCode,@Param("proName")String proName,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws Exception;
	
	/**
	 * 添加供应商
	 * @param provider
	 * @param connection
	 * @return int
	 * @throws Exception
	 */
	int addUser(Provider provider) throws Exception;
	
	/**
	 * 通过供应商Id查询供应商信息
	 * @param providerId
	 * @return Provider
	 * @throws Exception
	 */
	Provider findProvider(int providerId) throws Exception;
	
	/**
	 * 通过供应商Id修改供应商信息
	 * @param provider
	 * @return int
	 * @throws Exception
	 */
	int  modifyProvider(Provider provider)throws Exception;
}
