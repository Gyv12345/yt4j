package cn.yt4j.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gyv12345@163.com
 */
@Configuration
@ComponentScan(basePackages = "cn.yt4j.web")
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class WebAutoConfigConfiguration {

}
