package com.task;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigUtil {
	/** 配置文件对象 */
	private static Configuration config = null;
	
	/**
	 * 配置文件路径
	 */
	private static String properties = "config.properties";
	
	/**
	 * 
	 * 根据key获得配置文件中具体值
	 * 
	 * @param key
	 * @return
	 * @throws ConfigurationException
	 */
	private String getConfigFromProper(String key) throws ConfigurationException{
		config = new PropertiesConfiguration(this.getClass().getClassLoader()
				.getResource(properties));
		String value = config.getString(key);
		return value;
	}
	
	/**
	 * 
	 * 根据key获得值
	 * 
	 * @param key
	 * @return
	 * @throws ConfigurationException
	 */
	public String getConfig(String key) throws ConfigurationException{
		return getConfigFromProper(key);
	}
	
}
