package cn.yt4j.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.yt4j.security.model.UserCache;
import cn.yt4j.security.util.JwtUtil;
import cn.yt4j.sys.dao.SysMenuDao;
import cn.yt4j.sys.dao.SysRoleDao;
import cn.yt4j.sys.dao.SysUserDao;
import cn.yt4j.sys.entity.SysUser;
import cn.yt4j.sys.entity.dto.UserDTO;
import cn.yt4j.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 用户(SysUser)表服务实现类
 *
 * @author gyv12345@163.com
 * @since 2020-08-07 17:11:45
 */
@AllArgsConstructor
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

	private final PasswordEncoder encoder;

	private final JwtUtil jwtUtil;

	private final RedisTemplate<String, UserCache> redisTemplate;

	private final SysRoleDao sysRoleDao;

	private final SysMenuDao sysMenuDao;

	@Override
	public String login(UserDTO dto) {
		SysUser user = this.baseMapper
				.selectOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, dto.getUsername()));
		if (ObjectUtil.isNull(user)) {
			throw new BadCredentialsException("无此用户");
		}
		else {
			// 通过密码编码器比较密码
			if (encoder.matches(dto.getPassword(), user.getPassword())) {
				// 登录成功，创建token，我们需要在这里返回userDetail内容，包含权限信息,并将其放入redis，通过redis跨项目共享
				String token = jwtUtil.generateToken(user.getUsername());

				if (redisTemplate.hasKey(user.getUsername())) {
					redisTemplate.delete(user.getUsername());
				}

				UserCache cache = new UserCache();
				cache.setId(user.getId());
				BeanUtils.copyProperties(user, cache);
				cache.setRoles(sysRoleDao.listByUserId(user.getId()));
				cache.setMenus(sysMenuDao.listByUserId(user.getId()));

				redisTemplate.opsForValue().set(user.getUsername(), cache, 30L, TimeUnit.DAYS);

				return token;
			}
			else {
				throw new BadCredentialsException("用户或密码错误");
			}
		}
	}

}