package com.bdqn.smbms.util;

import java.io.IOException;
import java.io.InputStream;

import com.bdqn.smbms.controller.UserController;

/**
 * ��ȡ*.properties�����ļ�
 * 
 * @author ʩ����
 *
 */
public class Properties {

	/**
	 * ��ȡ*.properties�����ļ�
	 * 
	 * @param properties
	 * @return java.util.Properties
	 */
	public static java.util.Properties getProperties(String properties) {
		java.util.Properties propertie = new java.util.Properties();
		try {
			InputStream is = UserController.class.getClassLoader().getResourceAsStream(properties);
			propertie.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertie;
	}

	/**
	 * 
	 * @param properties
	 * @param key
	 * @return
	 */
	public static String getProperties(String properties, String key) {
		return getProperties(properties).getProperty(key);
	}

	/**
	 * 
	 * @param properties
	 * @param key
	 * @param key2
	 * @return
	 */
	public static String getString(String properties, String key, String key2) {
		return getProperties(getProperties(properties).getProperty(key)).getProperty(key2);
	}

	/**
	 * 
	 * @param key
	 * @param key2
	 * @return
	 */
	public static String getString(String key, String key2) {
		return getProperties(getProperties("spz.properties").getProperty(key)).getProperty(key2);
	}
}
