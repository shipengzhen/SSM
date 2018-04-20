package com.bdqn.app.service.developer;

import java.util.List;

import com.bdqn.app.pojo.AppVersion;

/**
 * App�汾Service��ӿ�
 * @author ʩ����
 *
 */
public interface IAppVersionService {

	/**
	 * ��ѯapp�汾
	 * @param appInfoId
	 * @return List<AppVersion>
	 */
	List<AppVersion> getAppVersions(Integer appInfoId);
	
	/**
	 * ����App�汾
	 * @param appVersion
	 * @return boolean
	 */
	boolean addAppVersion(AppVersion appVersion);
	
	/**
	 *��ѯ���°汾��Ϣ
	 * @param appId
	 * @return AppVersion
	 */
	AppVersion getNewAppVersion(Integer appId);
	
	/**
	 * ɾ��apk�ļ��ķ������洢·��
	 * @param varId
	 * @return boolean
	 */
	boolean deleteApkLocPath(Integer verId);
	
	/**
	 * ��ѯapk�ļ��ķ������洢·��
	 * @param verId
	 * @return String
	 */
	String getApkLocPath(Integer verId);
	
	/**
	 * �޸�App�汾
	 * @param appVersion
	 * @return boolean
	 */
	boolean modifyAppVersion(AppVersion appVersion);
}
