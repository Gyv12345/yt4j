
package cn.yt4j.im.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gyv12345@163.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "yt4j.im")
public class ImProperty {

	private String type;

	private String appId;

	private String appSecret;

}
