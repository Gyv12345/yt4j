package cn.yt4j.auth.controller;

import cn.yt4j.auth.service.AuthService;
import cn.yt4j.core.domain.R;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 鉴权
 *
 * @author gyv12345@163.com
 */
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("login")
	public R<String> login(@RequestBody @Validated LoginDTO dto) {
		return R.ok(authService.login(dto));
	}

}
