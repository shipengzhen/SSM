package com.spz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//��ȡ�����ļ��Ĺ�����-����ģʽ
public class ConfigManager {

	private static Properties properties;

	String configFile = "database.properties";

	public static ConfigManager getInstance() {
		return InnerConfigManager.configManager;
	}

	static class InnerConfigManager {
		static ConfigManager configManager = new ConfigManager();
	}

	// ˽�й�����-��ȡ���ݿ������ļ�
	private ConfigManager() {
		try {
			properties = new Properties();
			InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����key��ȡֵ
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	/**
	 * ����key��properties�����ļ���ȡֵ
	 * 
	 * @param key
	 * @param configFile
	 * @return
	 */
	public String getValue(String key, String configFile) {
		this.configFile = configFile;
		return properties.getProperty(key);
	}
}
