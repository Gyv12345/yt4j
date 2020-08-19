package cn.yt4j.sys.controller;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.security.util.SecurityUtil;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@AllArgsConstructor
@Api(tags = "用户")
@RestController
@RequestMapping("sys/user")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	private final RSA rsa;

	@ApiOperation("登录")
	@PostMapping("login")
	public R<String> login(@RequestBody @Valid UserDTO dto) {
		dto.setPassword(rsa.decryptStr(dto.getPassword(), KeyType.PrivateKey));
		return R.ok(this.sysUserService.login(dto), "登录成功");
	}

	@ApiOperation("修改密码")
	@PostMapping("update/password")
	public R<Boolean> updatePassword(@RequestBody @Valid PasswordDTO dto) {
		dto.setOldPwd(rsa.decryptStr(dto.getOldPwd(), KeyType.PrivateKey));
		dto.setNewPwd(rsa.decryptStr(dto.getNewPwd(), KeyType.PrivateKey));
		return R.ok(this.sysUserService.updatePassword(dto));
	}

	@ApiOperation("获取用户信息")
	@GetMapping("info")
	public R<UserInfo> getInfo() {
		return R.ok(this.sysUserService.getInfo(SecurityUtil.getUser().getId()));
	}

	/**
	 * 分页查询所有数据
	 * @param sysUser 查询实体
	 * @return 所有数据
	 */
	@ApiOperation("列表 ")
	@GetMapping("list")
	public R<PageResult<SysUser>> selectAll(SysUser sysUser) {
		return R.ok(this.sysUserService.page(PageUtil.page(), new QueryWrapper<>(sysUser)));
	}

	/**
	 * 通过主键查询单条数据
	 * @param id 主键
	 * @return 单条数据
	 */
	@ApiOperation("按ID返回用户")
	@GetMapping("get/{id}")
	public R<SysUser> selectOne(@PathVariable Long id) {
		return R.ok(this.sysUserService.one(id));
	}

	/**
	 * 新增数据
	 * @param sysUser 实体对象
	 * @return 新增结果
	 */
	@ApiOperation("添加 ")
	@PostMapping("insert")
	public R insert(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.insert(sysUser));
	}

	/**
	 * 修改数据
	 * @param sysUser 实体对象
	 * @return 修改结果
	 */
	@ApiOperation("修改 ")
	@PutMapping("update")
	public R update(@RequestBody SysUser sysUser) {
		return R.ok(this.sysUserService.update(sysUser));
	}

	/**
	 * 删除数据
	 * @param id 主键结合
	 * @return 删除结果
	 */
	@ApiOperation("删除")
	@DeleteMapping("delete/{id}")
	public R delete(@PathVariable Long id) {
		return R.ok(this.sysUserService.removeById(id));
	}

}