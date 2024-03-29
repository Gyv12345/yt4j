
package cn.yt4j.sys.api.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 登录实体
 *
 * @author gyv12345@163.com
 */
@Data
public class LoginDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 7380450222422017042L;

	/**
	 * 用户名
	 */
	@NotBlank(message = "登录用户名不能为空")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "登录密码不能为空")
	private String password;

}
