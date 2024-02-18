
package cn.yt4j.sys.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户信息
 *
 * @author gyv12345@163.com
 */
@Data
@ToString
public class UserDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 7380450222422017042L;

	/**
	 * 用户名
	 */
	@NotBlank
	private String username;

	/**
	 * 密码
	 */
	@NotBlank
	private String password;

}
