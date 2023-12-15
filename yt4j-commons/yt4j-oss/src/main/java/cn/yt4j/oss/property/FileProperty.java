
package cn.yt4j.oss.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 3.2版本后这个配置有了两个实例，也就是说ConfigurationProperties 会构建一个实例
 *
 * @author gyv12345@163.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "yt4j.file")
public class FileProperty {

	/**
	 * 存储方式
	 */
	private String fileType;

	/**
	 * 存储源
	 */
	private String bucketName;

	/**
	 * 存储源地址
	 */
	private String endpoint;

	/**
	 * 存储源用户
	 */
	private String accessKeyId;

	/**
	 * 存储源密码
	 */
	private String accessKeySecret;

	/**
	 * 存储源地域
	 */
	private String region;

	/**
	 * 存储源域名
	 */
	private String domain;

	/**
	 * 存储源路径
	 */
	private String basePath;

}
