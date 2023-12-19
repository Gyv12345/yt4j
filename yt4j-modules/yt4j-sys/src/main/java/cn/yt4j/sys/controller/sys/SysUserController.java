
package cn.yt4j.sys.controller.sys;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@Slf4j
@Tag(name = "用户")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	/**
	 * 登录已经废弃
	 * @param dto 登录信息
	 * @return 登录返回
	 */
	@SysLog("登录")
	@PostMapping("login")
	public Result<String> login(@RequestBody @Valid LoginDTO dto) {
		return Result.ok(this.sysUserService.login(dto), "登录成功");
	}

	/**
	 * 退出
	 * @return 退出返回
	 */
	@GetMapping("logout")
	public Result<Void> logout() {
		this.sysUserService.logout();
		return Result.ok("退出成功");
	}

	/**
	 * 修改密码
	 * @param dto 密码信息
	 * @return 结果
	 */
	@PostMapping("update/password")
	public Result<Boolean> updatePassword(@RequestBody @Valid PasswordDTO dto) {
		return Result.ok(this.sysUserService.updatePassword(dto));
	}

	/**
	 * 获取用户信息
	 * @return 结果
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
	public Result<Boolean> insert(@RequestBody SysUser sysUser) {
		return Result.ok(this.sysUserService.insert(sysUser));
	}

	/**
	 * 重置用户密码
	 * @param id 用户ID
	 * @return 结果
	 */
	@PostMapping("reset/password/{id}")
	public Result<Boolean> resetPassword(@PathVariable Long id) {
		return Result.ok(this.sysUserService.resetPassword(id));
	}

	/**
	 * 修改数据
	 * @param sysUser 实体对象
	 * @return 修改结果
	 */
	@PutMapping("update")
	public Result<Boolean> update(@RequestBody SysUser sysUser) {
		return Result.ok(this.sysUserService.update(sysUser));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@DeleteMapping("delete/{id}")
	public Result<Boolean> delete(@PathVariable Long id) {
		return Result.ok(this.sysUserService.removeById(id));
	}

	/**
	 * 根据用户名获取用户信息
	 * @param username 用户名
	 * @return 结果
	 */
	@SysLog("根据用户名获取用户信息")
	@PostMapping("/info/username")
	public Result<SysUser> getUserByUsername(@RequestParam String username) {
		log.info("根据用户名获取用户信息");
		return Result
				.ok(this.sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username)));
	}

	/**
	 * 在线用户
	 * @return 结果
	 */
	@SysLog("在线用户")
	@PostMapping("/online")
	public Result<List<String>> online() {
		List<String> list = StpUtil.searchSessionId("", 0, 1000, true);
		return Result.ok(list);
	}

}
