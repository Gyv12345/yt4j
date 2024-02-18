
package cn.yt4j.flow.work;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 连线
 *
 * @author gyv12345@163.com
 */
@Data
public class LineEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 5907732080447102514L;

	/**
	 * 连线标题
	 */
	private String label;

	/**
	 * 上级节点
	 */
	private String from;

	/**
	 * 到哪个节点
	 */
	private String to;

	/**
	 * 条件
	 */
	private String condition;

}
