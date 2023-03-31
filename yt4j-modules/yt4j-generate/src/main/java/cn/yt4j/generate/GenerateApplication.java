package cn.yt4j.generate;

import cn.yt4j.sa.annotaion.EnableYt4jSaToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 代码生成
 *
 * @author gyv12345@163.com
 */
@EnableYt4jSaToken
@EnableDiscoveryClient
@SpringBootApplication
public class GenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateApplication.class, args);
	}

}
