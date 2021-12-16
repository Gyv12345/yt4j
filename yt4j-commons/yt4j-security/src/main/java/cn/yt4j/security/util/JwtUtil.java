/*
 *    Copyright (c) [2020] [yang1989]
 *    [yt4j] is licensed under Mulan PSL v2.
 *    You can use this software according to the terms and conditions of the Mulan PSL v2.
 *    You may obtain a copy of Mulan PSL v2 at:
 *             http://license.coscl.org.cn/MulanPSL2
 *    THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 *    See the Mulan PSL v2 for more details.
 */

package cn.yt4j.security.util;

import cn.yt4j.security.property.JwtPayloadProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class JwtUtil {

	private final JwtPayloadProperty jwtPayloadProperty;

	/**
	 * 从令牌中获取数据声明
	 * @param token 令牌
	 * @return 数据声明
	 */
	private Claims getClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(jwtPayloadProperty.getSecret()))
				.build().parseClaimsJws(token).getBody();
	}

	/**
	 * 从令牌中获取认证的唯一标识
	 * @param token 令牌
	 * @return 用户id
	 */
	public String getSubjectFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		}
		catch (Exception e) {
			log.error("{}", e);
			username = null;
		}
		return username;
	}

	/**
	 * 验证令牌是否时间有效
	 * @param token 令牌
	 * @return 是否有效
	 */
	public Boolean validateToken(String token) {
		try {
			Claims claims = getClaimsFromToken(token);
			Date expiration = claims.getExpiration();
			Date notBefore = claims.getNotBefore();
			return new Date().after(notBefore) && new Date().before(expiration);
		}
		catch (Exception e) {
			log.error("{}", e);
			return false;
		}
	}

	/**
	 * 生成令牌
	 * @param username .
	 * @return .
	 */
	public String generateToken(String username) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtPayloadProperty.getSecret());
		Key key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return Jwts.builder()
				// jwt签发者
				.setIssuer(jwtPayloadProperty.getIssuer())
				// jwt所面向的用户
				.setSubject(username)
				// 接收jwt的一方
				.setAudience(jwtPayloadProperty.getAudience())
				.setExpiration(
						new Date(System.currentTimeMillis() + jwtPayloadProperty.getExpirationMinute() * 60 * 1000))
				.setNotBefore(
						new Date(System.currentTimeMillis() - jwtPayloadProperty.getNotBeforeMinute() * 60 * 1000))
				.setIssuedAt(new Date()).signWith(key).compact();
	}

}
