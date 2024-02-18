package cn.yt4j.sys.api.service.impl;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sys.api.entity.vo.SysUserVO;
import cn.yt4j.sys.api.service.LoginClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Component
public class LoginClientImpl implements LoginClient {

	@Override
	public Result<SysUserVO> getUserByUsername(String username) {
		return Result.ok();
	}

	@Override
	public Result<List<String>> listRoleByUserId(Long userId) {
		return Result.ok();
	}

	@Override
	public Result<List<String>> listMenuByUserId(Long userId) {
		return Result.ok();
	}

}
