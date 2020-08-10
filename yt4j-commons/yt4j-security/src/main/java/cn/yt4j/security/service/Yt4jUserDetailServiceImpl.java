package cn.yt4j.security.service;

import cn.yt4j.security.model.Yt4jUser;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Service
public class Yt4jUserDetailServiceImpl implements UserDetailsService {

	private final RedisTemplate<String, Yt4jUser> redisTemplate;

	@Override
	public UserDetails loadUserByUsername(String s) {
		if (redisTemplate.hasKey(s)) {
			Yt4jUser vo = redisTemplate.opsForValue().get(s);
			return vo;
		}
		return null;

	}

}
