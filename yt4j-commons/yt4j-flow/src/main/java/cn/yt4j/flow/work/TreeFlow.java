
package cn.yt4j.flow.work;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 流程树
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class TreeFlow implements Serializable {

	private String id;

	private String name;

	private String beanId;

	private String parentId;

	private String condition;

}
