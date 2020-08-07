package cn.yt4j.security.annotation;


import cn.yt4j.security.JwtServiceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author gyv12345@163.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({JwtServiceAutoConfiguration.class})
public @interface EnableYt4jSecurity {

}
