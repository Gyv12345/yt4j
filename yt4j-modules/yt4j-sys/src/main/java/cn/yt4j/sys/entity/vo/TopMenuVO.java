
package cn.yt4j.sys.entity.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * 应用信息
 *
 * @author gyv12345@163.com
 */
@Data
public class TopMenuVO implements Serializable {

	private static final long serialVersionUID = 8628688151192898733L;

	private String title;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	private String redirect;

}
