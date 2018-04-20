package com.bdqn.app.service.developer;

import java.util.List;

import com.bdqn.app.pojo.AppVersion;

/**
 * App版本Service层接口
 * @author 施鹏振
 *
 */
public interface IAppVersionService {

	/**
	 * 查询app版本
	 * @param appInfoId
	 * @return List<AppVersion>
	 */
	List<AppVersion> getAppVersions(Integer appInfoId);
	
	/**
	 * 新增App版本
	 * @param appVersion
	 * @return boolean
	 */
	boolean addAppVersion(AppVersion appVersion);
	
	/**
	 *查询最新版本信息
	 * @param appId
	 * @return AppVersion
	 */
	AppVersion getNewAppVersion(Integer appId);
	
	/**
	 * 删除apk文件的服务器存储路径
	 * @param varId
	 * @return boolean
	 */
	boolean deleteApkLocPath(Integer verId);
	
	/**
	 * 查询apk文件的服务器存储路径
	 * @param verId
	 * @return String
	 */
	String getApkLocPath(Integer verId);
	
	/**
	 * 修改App版本
	 * @param appVersion
	 * @return boolean
	 */
	boolean modifyAppVersion(AppVersion appVersion);
}
