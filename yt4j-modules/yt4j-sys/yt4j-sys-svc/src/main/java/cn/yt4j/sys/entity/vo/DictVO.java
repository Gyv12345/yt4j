
package cn.yt4j.sys.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 字典
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class DictVO implements Serializable {

	@Serial
	private static final long serialVersionUID = -7694822691794776892L;

	/**
	 * 标签名称
	 */
	private String label;

	/**
	 * 值
	 */
	private String value;

}
