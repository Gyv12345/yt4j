package cn.yt4j.feishu;


import cn.yt4j.im.properties.ImProperty;
import com.lark.oapi.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 飞书服务
 * @author gyv12345@163.com
 */
@ComponentScan(basePackageClasses=FieshuAutoConfiguration.class)
@RequiredArgsConstructor
@EnableAutoConfiguration
public class FieshuAutoConfiguration {

    private final ImProperty imProperty;

    @Bean
    public Client client() {
        return Client.newBuilder(imProperty.getAppId(), imProperty.getAppSecret()).build();
    }

}
