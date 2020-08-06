package cn.yt4j.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shichenyang
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.jwt.payload")
public class JwtPayloadProperty {

	/**
	 * user secret
	 */
	private String secret = "simple";

	/**
	 * issuer
	 */
	private String issuer = "simple-security-jwt";

	/**
	 * audience
	 */
	private String audience = "foo";

	/**
	 * expirationMinute default 30 day
	 */
	private int expirationMinute = 30 * 24 * 60 * 60;

	/**
	 * NotBefore default 15 minute
	 */
	private int notBeforeMinute = 15;

}
