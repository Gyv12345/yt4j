package cn.yt4j.auth.service;

import cn.yt4j.sys.api.entity.dto.LoginDTO;

/**
 * @author gyv12345@163.com
 */
public interface AuthService {

	/**
	 * 登录
	 * @param dto
	 * @return
	 */
	String login(LoginDTO dto);

}
