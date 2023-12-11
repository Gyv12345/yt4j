
package cn.yt4j.sa.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.2版本后这个配置有了两个实例，也就是说ConfigurationProperties 会构建一个实例
 * @author gyv12345@163.com
 */
@RefreshScope
@Data
@Component
@ConfigurationProperties(prefix = "yt4j.sa")
public class SaIgnoredUrlProperty {

	/**
	 * exclude url
	 */
	private List<String> ignoredUrl = new ArrayList<>();

}
