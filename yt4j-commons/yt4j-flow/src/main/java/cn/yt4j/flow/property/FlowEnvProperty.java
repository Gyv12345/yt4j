
package cn.yt4j.flow.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 流程设计器环境配置 两种方式，如果使用本地部署，直接读取本地文件 第二种方式需要部署流程服务端，通过feign的方式读取流程文件信息
 *
 * @author gyv12
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.flow.env")
public class FlowEnvProperty {

    private String type;
}
