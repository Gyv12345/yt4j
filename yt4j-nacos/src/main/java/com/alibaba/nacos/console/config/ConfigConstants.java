package com.alibaba.nacos.console.config;

/**
 * @author lengleng
 * @date 2019-10-31
 * <p>
 * 覆盖nacos 默认配置
 */
public interface ConfigConstants {
	/**
	 * The System property name of  Standalone mode
	 */
	String STANDALONE_MODE = "nacos.standalone";

	/**
	 * tomcat 目录
	 */
	String TOMCAT_DIR = "server.tomcat.basedir";

	/**
	 * tomcat 日志配置
	 */
	String TOMCAT_ACCESS_LOG = "server.tomcat.accesslog.enabled";
}
