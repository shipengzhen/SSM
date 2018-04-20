package com.spz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件的工具类-单例模式
public class ConfigManager {

	private static Properties properties;

	String configFile = "database.properties";

	public static ConfigManager getInstance() {
		return InnerConfigManager.configManager;
	}

	static class InnerConfigManager {
		static ConfigManager configManager = new ConfigManager();
	}

	// 私有构造器-读取数据库配置文件
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
	 * 传入key获取值
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	/**
	 * 传入key和properties配置文件获取值
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
