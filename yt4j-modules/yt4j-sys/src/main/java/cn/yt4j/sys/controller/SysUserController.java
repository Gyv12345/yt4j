/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@Api(tags = "用户系信息")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	private final RedisTemplate redisTemplate;

	@SysLog("登录")
	@PostMapping("login")
	public R<String> login(@RequestBody @Valid LoginDTO dto) {
		return R.ok(this.sysUserService.login(dto), "登录成功");
	}

	@GetMapping("logout")
	public R logout() {
		this.sysUserService.logout();
		return R.ok("退出成功");
	}

	@PostMapping("update/password")
	public R<Boolean> updatePassword(@RequestBody @Valid PasswordDTO dto) {
		return R.ok(this.sysUserService.updatePassword(dto));
	}

	@SysLog("获取用户信息")
	@GetMapping("info")
	public R<UserInfo> getInfo() {
		return R.ok(this.sysUserService.getInfo(Convert.toLong(StpUtil.getLoginId())));
	}

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@PostMapping("page")
	public R<PageResult<SysUser>> listPage(@Valid @RequestBody PageRequest<SysUser> request) {
		return R.ok(this.sysUserService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("get/{id}")
	public R<SysUser> selectOne(@PathVariable Long id) {
		return R.ok(this.sysUserService.one(id));
	}

	/**
	 * 新增数据
	 * @param sysUser 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public R insert(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.insert(sysUser));
	}

	/**
	 * 重置用户密码
	 * @param id 用户ID
	 * @return
	 */
	@PostMapping("reset/password/{id}")
	public R resetPassword(@PathVariable Long id) {
		return R.ok(this.sysUserService.resetPassword(id));
	}

	/**
	 * 修改数据
	 * @param sysUser 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public R update(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.update(sysUser));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysUserService.removeById(id));
	}

	@SysLog("根据用户名获取用户信息")
	@PostMapping("/info/username")
	public R<SysUser> getUserByUsername(@RequestParam String username) {
		return R.ok(this.sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username)));
	}

	@ApiOperation("在线用户")
	@SysLog("在线用户")
	@PostMapping("/online")
	public R online() {
		List<String> list= StpUtil.searchSessionId("",-1,0);
		return R.ok(list);
	}
}
