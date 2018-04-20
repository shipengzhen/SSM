package com.bdqn.app.dao.appversion;

import java.util.List;

import com.bdqn.app.pojo.AppVersion;

/**
 * App�汾��Dao��ӿ�
 * @author ʩ����
 *
 */
public interface IAppVersionDao {

	/**
	 * ��ѯapp�汾
	 * @param appInfoId
	 * @return List<AppVersion>
	 * @throws Exception
	 */
	List<AppVersion> findAppVersions(Integer appInfoId)throws Exception;
	
	/**
	 * ��ѯapp�汾������(û�õ�)
	 * @param appId
	 * @return Integer
	 * @throws Exception
	 */
	Integer findAppVersionCountByAppId(Integer appId)throws Exception;
	
	/**
	 * ����App�汾
	 * @param appVersion
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertAppVersion(AppVersion appVersion)throws Exception;
	
	/**
	 * ��ѯ���°汾��Ϣ
	 * @param appId
	 * @return AppVersion
	 */
	AppVersion findNewAppVersion(Integer appId)throws Exception;
	
	/**
	 * ɾ��apk�ļ��ķ������洢·��
	 * @param varId
	 * @return
	 * @throws Exception
	 */
	Integer updateApkLocPath(Integer verId)throws Exception;
	
	/**
	 * ��ѯapk�ļ��ķ������洢·��
	 * @param verId
	 * @return String
	 * @throws Exception
	 */
	String findApkLocPath(Integer verId)throws Exception;
	
	/**
	 * �޸�App�汾
	 * @param appVersion
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppVersion(AppVersion appVersion)throws Exception;
	
	/**
	 * ����appIdɾ����Ӧapp�İ汾
	 * @param appId
	 * @return Integer
	 * @throws Exception
	 */
	Integer deleteVersionByAppId(Integer appId)throws Exception;
}
