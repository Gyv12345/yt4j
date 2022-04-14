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

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.yt4j.core.domain.PageResult;
import cn.yt4j.core.domain.R;
import cn.yt4j.core.util.PageUtil;
import cn.yt4j.log.annotation.SysLog;
import cn.yt4j.security.util.SecurityUtil;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户(SysUser)表控制层
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class SysUserController {

	/**
	 * 服务对象
	 */
	private final SysUserService sysUserService;

	private final RSA rsa;

	@SysLog("登录")
	@PostMapping("login")
	public R<String> login(@RequestBody @Valid UserDTO dto) {
		dto.setPassword(rsa.decryptStr(dto.getPassword(), KeyType.PrivateKey));
		return R.ok(this.sysUserService.login(dto), "登录成功");
	}

	@GetMapping("logout")
	public R logout() {
		this.sysUserService.logout();
		return R.ok("退出成功");
	}

	@PostMapping("update/password")
	public R<Boolean> updatePassword(@RequestBody @Valid PasswordDTO dto) {
		dto.setOldPwd(rsa.decryptStr(dto.getOldPwd(), KeyType.PrivateKey));
		dto.setNewPwd(rsa.decryptStr(dto.getNewPwd(), KeyType.PrivateKey));
		return R.ok(this.sysUserService.updatePassword(dto));
	}

	@SysLog("登录")
	@GetMapping("info")
	public R<UserInfo> getInfo() {
		return R.ok(this.sysUserService.getInfo(SecurityUtil.getUser().getId()));
	}

	/**
	 * 分页查询所有数据
	 * @param sysUser 查询实体
	 * @return 所有数据
	 */
	@GetMapping("list")
	public R<PageResult<SysUser>> selectAll(SysUser sysUser) {
		return R.ok(this.sysUserService.page(PageUtil.page(), new QueryWrapper<>(sysUser)));
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

}
