package cn.yt4j.sys.api.service.impl;

import cn.yt4j.core.domain.Result;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gyv12345@163.com
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public Result<SysUser> getUserByUsername(String username) {
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
