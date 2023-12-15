
package cn.yt4j.sys.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 密码修改实体
 *
 * @author gyv12345@163.com
 */
@Schema(description = "密码修改实体")
@Data
public class PasswordDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1452308634694192510L;

	/**
	 * 旧密码
	 */
	@NotNull
	private String oldPwd;

	/**
	 * 新密码
	 */
	@NotNull
	private String newPwd;

}
