package com.bdqn.app.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.app.pojo.AppCategory;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.DataDictionary;

/**
 * AppDao层接口
 * 
 * @author 施鹏振
 *
 */
public interface IAppInfoDao {

	/**
	 * APP状态，所属平台
	 * 
	 * @param typeName
	 * @return List<DataDictionary>
	 * @throws Exception
	 */
	List<DataDictionary> findValueName(String typeName) throws Exception;

	/**
	 * 一，二,三级分类
	 * 
	 * @param parentId
	 * @return List<AppCategory>
	 * @throws Exception
	 */
	List<AppCategory> findCategoryLevel(Integer parentId) throws Exception;

	/**
	 * 查询app信息(分页)
	 * 
	 * @param appInfo
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<AppInfo>
	 * @throws Exception
	 */
	List<AppInfo> findAppInfos(@Param("appInfo") AppInfo appInfo, @Param("currentPageNo") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 查询app信息的数量(分页)
	 * 
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer findAppInfosCount(@Param("appInfo")AppInfo appInfo) throws Exception;
	
	/**
	 * 新增App信息
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertAppInfo(@Param("appInfo")AppInfo appInfo)throws Exception;
	
	/**
	 * 查询App信息
	 * @param appInfoId
	 * @return AppInfo
	 * @throws Exception
	 */
	AppInfo findAppInfo(Integer appInfoId)throws Exception;
	
	/**
	 * 判断APKName是否存在
	 * @param APKName
	 * @return Integer
	 */
	Integer findAppInfoCount(String APKName)throws Exception;
	
	/**
	 * 删除AppLogo
	 * @param appInfoId
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppLogo(Integer appInfoId)throws Exception;
	
	/**
	 * 修改App信息
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppInfo(@Param("appInfo")AppInfo appInfo)throws Exception;
	
	/**
	 * 修改App最新版本
	 * @param appId
	 * @return Integer
	 */
	Integer updateVersionId(Integer appId);
	
	/**
	 * 根据appId删除App信息
	 * @param appId
	 * @return Integer
	 */
	Integer deleteAppInfoByAppId(Integer appId)throws Exception;
}
