package cn.yt4j.core.sensitive;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对象脱敏注解
 *
 * @author mayee
 * @version v1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveSerialize.class)
public @interface Sensitive {

	/**
	 * 脱敏数据类型, 非Customer时, 将忽略 refixNoMaskLen 和 suffixNoMaskLen 和 maskStr
	 */
	SensitiveTypeEnum type() default SensitiveTypeEnum.CUSTOMER;

	/**
	 * 前置不需要打码的长度
	 */
	int prefixNoMaskLen() default 0;

	/**
	 * 后置不需要打码的长度
	 */
	int suffixNoMaskLen() default 0;

	/**
	 * 用什么打码
	 */
	String maskStr() default "*";

}
