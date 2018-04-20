package com.bdqn.app.tools;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取*.properties配置文件
 * @author 施鹏振
 *
 */
public class Properties {

	/**
	 * 读取*.properties配置文件
	 * @param properties
	 * @return java.util.Properties
	 */
	public static java.util.Properties getProperties(String properties){
		java.util.Properties propertie=new java.util.Properties();
		try {
			InputStream is=Properties.class.getClassLoader().getResourceAsStream(properties);
			propertie.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return propertie;
	}
	
	/**
	 * 
	 * @param properties 主properties全名
	 * @param key
	 * @return
	 */
	public static String getProperties(String properties,String key){
		return getProperties(properties).getProperty(key);
	}
	
	/**
	 * 
	 * @param properties
	 * @param key
	 * @param key2
	 * @return
	 */
	public static String getString(String properties,String key,String key2){
		return getProperties(getProperties(properties).getProperty(key)).getProperty(key2);
	}
	
	/**
	 * 
	 * @param key
	 * @param key2
	 * @return
	 */
	public static String getString(String key,String key2){
		return getProperties(getProperties("spz.properties").getProperty(key)).getProperty(key2);
	}
}
