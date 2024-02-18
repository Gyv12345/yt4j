package cn.yt4j.sys.api.service;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sa.config.FeignInterceptor;
import cn.yt4j.sys.api.entity.vo.SysUserVO;
import cn.yt4j.sys.api.service.impl.LoginClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 登录
 *
 * @author gyv12345@163.com
 */
@FeignClient(name = "yt4j-sys", contextId = "login", configuration = FeignInterceptor.class,
		fallback = LoginClientImpl.class)
public interface LoginClient {

	/**
	 * 登录
	 * @param username
	 * @return
	 */
	@PostMapping("/user/info/username")
	Result<SysUserVO> getUserByUsername(@RequestParam("username") String username);

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	@GetMapping("/role/auth/list")
	Result<List<String>> listRoleByUserId(@RequestParam("userId") Long userId);

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	@GetMapping("/menu/auth/list")
	Result<List<String>> listMenuByUserId(@RequestParam("userId") Long userId);

}
