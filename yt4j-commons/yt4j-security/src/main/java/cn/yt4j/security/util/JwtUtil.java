package cn.yt4j.security.util;

import cn.yt4j.security.property.JwtPayloadProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author shichenyang
 */
@AllArgsConstructor
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
		return Jwts.parser().setSigningKey(jwtPayloadProperty.getSecret()).parseClaimsJws(token).getBody();
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
	 * @param userId .
	 * @return .
	 */
	public String generateToken(String userId) {
		return Jwts.builder()
				// jwt签发者
				.setIssuer(jwtPayloadProperty.getIssuer())
				// jwt所面向的用户
				.setSubject(userId)
				// 接收jwt的一方
				.setAudience(jwtPayloadProperty.getAudience())
				.setExpiration(
						new Date(System.currentTimeMillis() + jwtPayloadProperty.getExpirationMinute() * 60 * 1000))
				.setNotBefore(
						new Date(System.currentTimeMillis() - jwtPayloadProperty.getNotBeforeMinute() * 60 * 1000))
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, jwtPayloadProperty.getSecret()).compact();
	}

}
