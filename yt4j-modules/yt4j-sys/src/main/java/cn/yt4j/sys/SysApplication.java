package cn.yt4j.sys;

import cn.yt4j.security.annotation.EnableYt4jSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gyv12345@163.com
 */
@EnableYt4jSecurity
@SpringBootApplication
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);
	}

}
