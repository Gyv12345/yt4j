package cn.yt4j.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gyv12345@163.com
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.jwt.payload")
public class JwtPayloadProperty {

	/**
	 * user secret
	 */
	private String secret = "yt4j";

	/**
	 * issuer
	 */
	private String issuer = "yt4j.cn";

	/**
	 * audience
	 */
	private String audience = "vip";

	/**
	 * expirationMinute default 30 day
	 */
	private int expirationMinute = 30 * 24 * 60 * 60;

	/**
	 * NotBefore default 15 minute
	 */
	private int notBeforeMinute = 15;

}
