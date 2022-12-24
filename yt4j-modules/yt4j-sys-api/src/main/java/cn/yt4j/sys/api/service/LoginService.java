package cn.yt4j.sys.api.service;

import cn.yt4j.core.domain.R;
import cn.yt4j.sa.config.FeignInterceptor;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.service.impl.LoginServiceImpl;
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
		fallback = LoginServiceImpl.class)
public interface LoginService {

	/**
	 * 登录
	 * @param username
	 * @return
	 */
	@PostMapping("/user/info/username")
	R<SysUser> getUserByUsername(@RequestParam("username") String username);

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	@GetMapping("/role/auth/list")
	R<List<String>> listRoleByUserId(@RequestParam("userId") Long userId);

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	@GetMapping("/menu/auth/list")
	R<List<String>> listMenuByUserId(@RequestParam("userId") Long userId);

}
