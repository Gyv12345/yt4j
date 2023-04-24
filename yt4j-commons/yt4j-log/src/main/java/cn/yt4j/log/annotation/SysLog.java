
package cn.yt4j.log.annotation;

import java.lang.annotation.*;

/**
 * @author gyv12345@163.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 * @return {String}
	 */
	String value();

}
