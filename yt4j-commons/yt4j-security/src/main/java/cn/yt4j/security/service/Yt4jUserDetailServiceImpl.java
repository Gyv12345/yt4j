package cn.yt4j.security.service;

import cn.yt4j.security.model.UserCache;
import cn.yt4j.security.model.Yt4jUser;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gyv12345@163.com
 */
@AllArgsConstructor
@Service
public class Yt4jUserDetailServiceImpl implements UserDetailsService {

	private final RedisTemplate<String, UserCache> redisTemplate;

	@Override
	public UserDetails loadUserByUsername(String s) {
		if (redisTemplate.hasKey(s)) {
			UserCache vo = redisTemplate.opsForValue().get(s);

			List<GrantedAuthority> authorities = new ArrayList<>();

			authorities.addAll(
					vo.getRoles().stream().map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList()));

			authorities.addAll(
					vo.getMenus().stream().map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList()));

			Yt4jUser user = new Yt4jUser(vo.getUsername(), vo.getPassword(), authorities, vo.getId());
			return user;
		}
		return null;

	}

}
