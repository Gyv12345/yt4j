package cn.yt4j.feishu;

import cn.yt4j.im.properties.ImProperty;
import com.lark.oapi.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 飞书服务
 *
 * @author gyv12345@163.com
 */
@ComponentScan(basePackages = "cn.yt4j.feishu")
@RequiredArgsConstructor
@Import(ImProperty.class)
public class FeishuAutoConfiguration {

	private final ImProperty imProperty;

	@Bean
	public Client client() {
		return Client.newBuilder(imProperty.getAppId(), imProperty.getAppSecret()).build();
	}

}
