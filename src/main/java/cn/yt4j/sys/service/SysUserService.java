package cn.yt4j.sys.service;

import cn.yt4j.security.model.Yt4jUser;
import cn.yt4j.sys.entity.SysRole;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.PasswordDTO;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.entity.vo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 用户(SysUser)表服务接口
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:44
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 登录
	 * @param dto
	 * @return
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
	 * 分页查询
	 * @param user
	 * @return
	 */
	List<SysUser> page(SysUser user);

	/**
	 * 重置用户密码
	 * @param id
	 * @return
	 */
	Boolean resetPassword(Long id);

}
