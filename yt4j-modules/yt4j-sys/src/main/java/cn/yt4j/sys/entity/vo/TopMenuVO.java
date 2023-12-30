
package cn.yt4j.sys.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 应用信息
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class TopMenuVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 8628688151192898733L;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 重定向
	 */
	private String redirect;

}
