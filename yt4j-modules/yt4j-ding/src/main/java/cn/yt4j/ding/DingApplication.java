package cn.yt4j.ding;

import cn.yt4j.security.annotation.EnableYt4jSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gyv12345@163.com
 */
@EnableDiscoveryClient
@EnableYt4jSecurity
@SpringBootApplication
public class DingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DingApplication.class, args);
	}

}
