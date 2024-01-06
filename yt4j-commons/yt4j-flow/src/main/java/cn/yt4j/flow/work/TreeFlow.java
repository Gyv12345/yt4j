
package cn.yt4j.flow.work;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 流程树
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class TreeFlow implements Serializable {

	@Serial
	private static final long serialVersionUID = -5512024826798480157L;

	/**
	 * 规则对象的唯一标识符
	 */
	private String id;

	/**
	 * 规则对象的名称
	 */
	private String name;

	/**
	 * 规则对象在 Spring Bean 中的唯一标识符
	 */
	private String beanId;

	/**
	 * 规则对象的父级对象标识符
	 */
	private String parentId;

	/**
	 * 规则对象的条件
	 */
	private String condition;

}
