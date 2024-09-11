package cn.yt4j.sys.api.entity.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class LoginVO implements Serializable {

	@Serial
	private static final long serialVersionUID = -1515321976565114705L;

	/**
	 * 用户吗
	 */
	private String username;

	/**
	 * 角色
	 */
	private List<String> roles;

	/**
	 * token
	 */
	private String accessToken;

	private String refreshToken;

	/**
	 * yyyy/MM/dd HH:mm:ss
	 */
	private String expires;

}
