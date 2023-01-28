package cn.yt4j.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * @author gyv12345@163.com
 */
@Slf4j
public class WebFluxUtil {

	private static final String IP_UNKNOWN = "unknown";

	private static final String IP_LOCAL = "127.0.0.1";

	private static final String IPV6_LOCAL = "0:0:0:0:0:0:0:1";

	private static final int IP_LEN = 15;

	/**
	 * 获取用户真实IP地址，不直接使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 *
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 *
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
	 *
	 * 用户真实IP为： 192.168.1.110
	 * @param request
	 * @return
	 */
	public static String getIpAddress(ServerHttpRequest request) {
		HttpHeaders headers = request.getHeaders();
		String ipAddress = headers.getFirst("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
			ipAddress = headers.getFirst("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
			ipAddress = headers.getFirst("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
			ipAddress = Optional.ofNullable(request.getRemoteAddress())
					.map(address -> address.getAddress().getHostAddress()).orElse("");
			if (IP_LOCAL.equals(ipAddress) || IPV6_LOCAL.equals(ipAddress)) {
				// 根据网卡取本机配置的IP
				try {
					InetAddress inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				}
				catch (UnknownHostException e) {
					log.error(e.getMessage());
				}
			}
		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > IP_LEN) {
			int index = ipAddress.indexOf(",");
			if (index > 0) {
				ipAddress = ipAddress.substring(0, index);
			}
		}
		return ipAddress;
	}

}
