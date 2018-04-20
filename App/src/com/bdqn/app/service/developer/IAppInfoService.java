package com.bdqn.app.service.developer;

import java.util.List;

import com.bdqn.app.pojo.AppCategory;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.DataDictionary;

/**
 * AppService层接口
 * 
 * @author 施鹏振
 *
 */
public interface IAppInfoService {

	/**
	 * APP状态
	 * 
	 * @return List<DataDictionary>
	 */
	List<DataDictionary> getAppType();

	/**
	 * 所属平台
	 * 
	 * @return List<DataDictionary>
	 */
	List<DataDictionary> getAppPlatform();

	/**
	 * 一级分类
	 * 
	 * @return List<AppCategory>
	 */
	List<AppCategory> getCategoryLevel1();

	/**
	 * 二,三级分类
	 * 
	 * @param parentId
	 * @return List<AppCategory>
	 */
	List<AppCategory> getCategoryLevel(Integer parentId);

	/**
	 * 模糊查询app信息(分页)
	 * 
	 * @param appInfo
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<AppInfo>
	 */
	List<AppInfo> getAppInfos(AppInfo appInfo, Integer currentPageNo, Integer pageSize);

	/**
	 * 模糊查询app信息总数量(分页)
	 * 
	 * @param appInfo
	 * @return Integer
	 */
	Integer getAppInfosCount(AppInfo appInfo);
	
	/**
	 * 新增App信息
	 * @param appInfo
	 * @return boolean
	 * @throws Exception
	 */
	boolean addAppInfo(AppInfo appInfo);
	
	/**
	 * 查询App信息
	 * @param appInfoId
	 * @return AppInfo
	 */
	AppInfo getAppInfo(Integer appInfoId);
	
	/**
	 * 判断APKName是否存在
	 * @param APKName
	 * @return boolean
	 */
	boolean getApkexist(String APKName);
	
	/**
	 * 删除AppLogo
	 * @param appInfoId
	 * @return boolean
	 */
	boolean deleteAppLogo(Integer appInfoId);
	
	/**
	 * 修改App信息
	 * @param appInfo
	 * @return boolean
	 */
	boolean modifyAppInfo(AppInfo appInfo);
	
	/**
	 * 根据appId删除app信息及版本信息
	 * @param appId
	 * @return boolean
	 */
	boolean deleteAppByAppId(Integer appId);
	
	/**
	 * 修改App状态
	 * @param appId
	 * @param devId
	 * @return boolean
	 */
	boolean modifyAppStatusByAppId(Integer appId,Integer devId);
	
	/**
	 * 上架
	 * @param appInfo
	 * @return boolean
	 */
	boolean onSale(AppInfo appInfo);
	
	/**
	 *  下架
	 * @param appInfo
	 * @return boolean
	 */
	boolean offSale(AppInfo appInfo);
	
	/**
	 * 修改app信息
	 * @param appInfo
	 * @return boolean
	 */
	boolean App(AppInfo appInfo);
	
	/**
	 * 修改app版本信息
	 * @param appInfo
	 * @return boolean
	 */
	boolean Version(AppInfo appInfo);
}
