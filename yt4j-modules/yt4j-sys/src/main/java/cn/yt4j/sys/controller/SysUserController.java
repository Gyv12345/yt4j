
package cn.yt4j.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.yt4j.core.domain.PageRequest;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.Result;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.sys.api.entity.SysUser;
import cn.yt4j.sys.api.entity.dto.LoginDTO;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@Tag(name = "用户")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	private final RedisTemplate redisTemplate;

	/**
	 * 登录已经废弃
	 * @param dto
	 * @return
	 */
	@SysLog("登录")
	@PostMapping("login")
	public Result<String> login(@RequestBody @Valid LoginDTO dto) {
		return Result.ok(this.sysUserService.login(dto), "登录成功");
	}

	/**
	 * 退出
	 * @return
	 */
	@GetMapping("logout")
	public Result logout() {
		this.sysUserService.logout();
		return Result.ok("退出成功");
	}

	/**
	 * 修改密码
	 * @param dto
	 * @return
	 */
	@PostMapping("update/password")
	public Result<Boolean> updatePassword(@RequestBody @Valid PasswordDTO dto) {
		return Result.ok(this.sysUserService.updatePassword(dto));
	}

	/**
	 * 获取用户信息
	 * @return
	 */
	@SysLog("获取用户信息")
	@GetMapping("info")
	public Result<UserInfo> getInfo() {
		return Result.ok(this.sysUserService.getInfo(StpUtil.getLoginIdAsLong()));
	}

	/**
	 * 分页查询所有数据
	 * @param request 查询实体
	 * @return 所有数据
	 */
	@PostMapping("page")
	public Result<PageResult<SysUser>> listPage(@Valid @RequestBody PageRequest<SysUser> request) {
		return Result.ok(this.sysUserService.page(request.page(), request.wrapper()));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("get/{id}")
	public Result<SysUser> selectOne(@PathVariable Long id) {
		return Result.ok(this.sysUserService.one(id));
	}

	/**
	 * 新增数据
	 * @param sysUser 实体对象
	 * @return 新增结果
	 */
	@PostMapping("insert")
	public Result insert(@RequestBody SysUser sysUser) {
		return Result.ok(this.sysUserService.insert(sysUser));
	}

	/**
	 * 重置用户密码
	 * @param id 用户ID
	 * @return
	 */
	@PostMapping("reset/password/{id}")
	public Result resetPassword(@PathVariable Long id) {
		return Result.ok(this.sysUserService.resetPassword(id));
	}

	/**
	 * 修改数据
	 * @param sysUser 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public Result update(@RequestBody SysUser sysUser) {
		return Result.ok(this.sysUserService.update(sysUser));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable Long id) {
		return Result.ok(this.sysUserService.removeById(id));
	}

	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return
	 */
	@SysLog("根据用户名获取用户信息")
	@PostMapping("/info/username")
	public Result<SysUser> getUserByUsername(@RequestParam String username) {
		return Result
				.ok(this.sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username)));
	}

	/**
	 * 在线用户
	 * @return
	 */
	@SysLog("在线用户")
	@PostMapping("/online")
	public Result online() {
		List<String> list = StpUtil.searchSessionId("", 0, 1000, true);
		return Result.ok(list);
	}

}
