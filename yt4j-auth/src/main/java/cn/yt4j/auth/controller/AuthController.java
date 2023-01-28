package cn.yt4j.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.auth.service.AuthService;
import cn.yt4j.core.domain.R;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 鉴权
 *
 * @author gyv12345@163.com
 */
@Tag(name = "鉴权")
@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	/**
	 * @param dto
	 * @return
	 */
	@Operation(summary = "登录")
	@SysLog("登录")
	@PostMapping("login")
	public R<Map> login(@RequestBody @Validated LoginDTO dto) {
		Map<String, String> map = new HashMap<>();
		String token = authService.login(dto);
		map.put("token", token);
		return R.ok(map);
	}

	/**
	 * @return
	 */
	@Operation(summary = "退出登录")
	@SysLog("退出登录")
	@GetMapping("logout")
	public R logout() {
		StpUtil.logout();
		return R.ok();
	}

}
