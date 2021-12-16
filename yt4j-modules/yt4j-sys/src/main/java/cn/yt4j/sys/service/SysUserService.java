/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.sys.service;

import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户(SysUser)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:44
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 登录
	 *
	 * @param dto dto
	 * @return {@link String}
	 */
	String login(UserDTO dto);

	/**
	 * 退出
	 */
	void logout();

	/**
	 * 修改密码
	 * @param dto
	 * @return
	 */
	Boolean updatePassword(PasswordDTO dto);

	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	UserInfo getInfo(Long id);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Boolean insert(SysUser user);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	Boolean update(SysUser user);

	/**
	 * 获取一个
	 * @param id
	 * @return
	 */
	SysUser one(Long id);

	/**
	 * 重置用户密码
	 * @param id
	 * @return
	 */
	Boolean resetPassword(Long id);

}
