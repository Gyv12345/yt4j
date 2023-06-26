package cn.yt4j.flowserver;

import cn.yt4j.sa.annotaion.EnableYt4jSaToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 流程编排服务端
 *
 * @author gyv12345@163.com
 */
@EnableYt4jSaToken
@EnableDiscoveryClient
@SpringBootApplication
public class FlowServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowServerApplication.class, args);
	}

}
