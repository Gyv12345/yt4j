package cn.yt4j.auth.service;

import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.api.entity.vo.LoginVO;

/**
 * 鉴权服务
 *
 * @author gyv12345@163.com
 */
public interface AuthService {

	/**
	 * 登录
	 * @param dto 登录参数
	 * @return token
	 */
	LoginVO login(LoginDTO dto);

}
