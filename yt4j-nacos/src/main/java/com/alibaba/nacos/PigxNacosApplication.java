

package com.alibaba.nacos;

import com.alibaba.nacos.console.config.ConfigConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author nacos
 * <p>
 * nacos console 源码运行，方便开发
 * 生产建议从官网下载最新版配置运行
 */
@EnableScheduling
@SpringBootApplication
public class PigxNacosApplication {

	public static void main(String[] args) {
		System.setProperty(ConfigConstants.TOMCAT_DIR, "logs");
		System.setProperty(ConfigConstants.TOMCAT_ACCESS_LOG, "false");
		System.setProperty(ConfigConstants.STANDALONE_MODE, "true");
		SpringApplication.run(PigxNacosApplication.class, args);
	}
}
