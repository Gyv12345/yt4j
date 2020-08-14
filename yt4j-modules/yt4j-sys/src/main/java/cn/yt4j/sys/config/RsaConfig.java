package cn.yt4j.sys.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.RSA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 非对称加密
 * @author gyv12
 */
@Configuration
public class RsaConfig {

    @Value("${yt4j.rsa.private-key}")
    private String privateKey;

    @Bean
    public RSA create(){
        return new RSA(StrUtil.cleanBlank(privateKey), null);
    }
}
