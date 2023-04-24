
package cn.yt4j.sa.annotaion;

import cn.yt4j.sa.SaAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author gyv12345@163.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(SaAutoConfiguration.class)
public @interface EnableYt4jSaToken {

}
