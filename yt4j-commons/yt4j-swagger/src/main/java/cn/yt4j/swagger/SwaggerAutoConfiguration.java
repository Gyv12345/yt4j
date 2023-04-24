
package cn.yt4j.swagger;

import cn.yt4j.swagger.properties.SwaggerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger配置
 *
 * @author gyv12345@163.com
 */
@Configuration
@ConditionalOnProperty(name = "yt4j.swagger.enabled", havingValue = "true")
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {

	@Bean
	public OpenAPI customOpenAPI(SwaggerProperties swaggerProperties) {
		OpenAPI openAPI = new OpenAPI();
		openAPI.setInfo(swaggerProperties.getInfo());
		return openAPI;
	}

}
