package cn.yt4j.sys;

import cn.yt4j.security.annotation.EnableYt4jSecurity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author gyv12345@163.com
 */
@EnableCaching
@MapperScan("cn.yt4j.sys.dao")
@EnableYt4jSecurity
@SpringBootApplication
public class SysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysApplication.class, args);
	}

}
