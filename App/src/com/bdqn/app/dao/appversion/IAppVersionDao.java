package com.bdqn.app.dao.appversion;

import java.util.List;

import com.bdqn.app.pojo.AppVersion;

/**
 * App版本号Dao层接口
 * @author 施鹏振
 *
 */
public interface IAppVersionDao {

	/**
	 * 查询app版本
	 * @param appInfoId
	 * @return List<AppVersion>
	 * @throws Exception
	 */
	List<AppVersion> findAppVersions(Integer appInfoId)throws Exception;
	
	/**
	 * 查询app版本的数量(没用到)
	 * @param appId
	 * @return Integer
	 * @throws Exception
	 */
	Integer findAppVersionCountByAppId(Integer appId)throws Exception;
	
	/**
	 * 新增App版本
	 * @param appVersion
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertAppVersion(AppVersion appVersion)throws Exception;
	
	/**
	 * 查询最新版本信息
	 * @param appId
	 * @return AppVersion
	 */
	AppVersion findNewAppVersion(Integer appId)throws Exception;
	
	/**
	 * 删除apk文件的服务器存储路径
	 * @param varId
	 * @return
	 * @throws Exception
	 */
	Integer updateApkLocPath(Integer verId)throws Exception;
	
	/**
	 * 查询apk文件的服务器存储路径
	 * @param verId
	 * @return String
	 * @throws Exception
	 */
	String findApkLocPath(Integer verId)throws Exception;
	
	/**
	 * 修改App版本
	 * @param appVersion
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppVersion(AppVersion appVersion)throws Exception;
	
	/**
	 * 根据appId删除相应app的版本
	 * @param appId
	 * @return Integer
	 * @throws Exception
	 */
	Integer deleteVersionByAppId(Integer appId)throws Exception;
}
