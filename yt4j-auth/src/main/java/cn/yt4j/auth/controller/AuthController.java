package cn.yt4j.auth.controller;

import cn.yt4j.auth.service.AuthService;
import cn.yt4j.core.domain.R;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
@Api(tags = "鉴权服务")
@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@SysLog("登录")
	@ApiOperation("登录")
	@PostMapping("login")
	public R<Map> login(@RequestBody @Validated LoginDTO dto) {
		Map<String, String> map = new HashMap<>();
		String token = authService.login(dto);
		map.put("token", token);
		return R.ok(map);
	}

}
