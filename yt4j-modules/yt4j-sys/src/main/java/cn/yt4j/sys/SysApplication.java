
package cn.yt4j.sys;

import cn.yt4j.sa.annotaion.EnableYt4jSaToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gyv12345@163.com
 */
@EnableYt4jSaToken
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);
	}

}
