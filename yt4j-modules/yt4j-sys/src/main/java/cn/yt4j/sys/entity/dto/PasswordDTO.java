package cn.yt4j.sys.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author gyv12345@163.com
 */
@Data
public class PasswordDTO implements Serializable {

	private static final long serialVersionUID = 1452308634694192510L;

	@NotNull
	private String oldPwd;

	@NotNull
	private String newPwd;

}
