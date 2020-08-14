package cn.yt4j.sys.service;

import cn.yt4j.security.model.Yt4jUser;
import cn.yt4j.sys.entity.SysUser;
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
	 * @param dto
	 * @return
	 */
	String login(UserDTO dto);

	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	UserInfo getInfo(Long id);

}