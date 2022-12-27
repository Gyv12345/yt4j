/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.security.service;

import cn.yt4j.core.constant.SecurityConstants;
import cn.yt4j.security.model.UserCache;
import cn.yt4j.security.model.Yt4jUser;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Service
public class Yt4jUserDetailServiceImpl implements UserDetailsService {

	private final RedisTemplate<String, UserCache> redisTemplate;

	@Override
	public UserDetails loadUserByUsername(String s) {
		if (redisTemplate.hasKey(SecurityConstants.SECURITY_PREFIX + s)) {
			UserCache vo = redisTemplate.opsForValue().get(SecurityConstants.SECURITY_PREFIX + s);

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
