
package cn.yt4j.sa;

import cn.yt4j.sa.property.SaIgnoredUrlProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gyv12345@163.com
 */
@Configuration
@ComponentScan("cn.yt4j.sa")
@EnableAutoConfiguration
@EnableConfigurationProperties({ SaIgnoredUrlProperty.class })
public class SaAutoConfiguration {

}
