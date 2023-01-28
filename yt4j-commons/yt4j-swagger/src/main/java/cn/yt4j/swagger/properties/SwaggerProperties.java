package cn.yt4j.swagger.properties;

import io.swagger.v3.oas.models.info.Info;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger 配置属性
 *
 * @author gyv12345@163.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "yt4j.swagger")
public class SwaggerProperties {

    /**
     * 是否开启 openApi 文档
     */
    private Boolean enabled = true;

    /**
     * 文档基本信息
     */
    private Info info = new Info();

}
