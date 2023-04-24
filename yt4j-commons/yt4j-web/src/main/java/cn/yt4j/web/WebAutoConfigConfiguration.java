
package cn.yt4j.web;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gyv12345@163.com
 */
@AutoConfiguration
@ComponentScan(basePackages = "cn.yt4j.web")
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebAutoConfigConfiguration {

}
