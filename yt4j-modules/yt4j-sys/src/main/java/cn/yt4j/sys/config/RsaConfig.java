
package cn.yt4j.sys.config;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 非对称加密
 *
 * @author gyv12345@163.com
 */
@Configuration
public class RsaConfig {

	@SneakyThrows
	@Bean
	public RSA create() {
		String PK = "rsaKey/private.key";
		ClassPathResource resource = new ClassPathResource(PK);
		String privateKey = IoUtil.read(resource.getInputStream(), CharsetUtil.charset("utf-8"));
		return new RSA(StrUtil.cleanBlank(privateKey), null);
	}

}
