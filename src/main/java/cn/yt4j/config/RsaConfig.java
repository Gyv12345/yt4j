package cn.yt4j.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		ClassPathResource resource = new ClassPathResource("rsaKey/private.key");

		String privateKey = getStringFromInputStream(resource.getInputStream());
		return new RSA(StrUtil.cleanBlank(privateKey), null);
	}

	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
