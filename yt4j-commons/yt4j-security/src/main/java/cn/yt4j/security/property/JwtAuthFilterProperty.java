package cn.yt4j.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shichenyang
 */
@Component
@Data
@ConfigurationProperties(prefix = "yt4j.jwt.filter")
public class JwtAuthFilterProperty {

    /**
     * request header key
     */
    private String header = HttpHeaders.AUTHORIZATION;

    /**
     * request header value start
     */
    private String tokenHead = "Bearer ";

    /**
     * exclude url
     */
    private List<String> ignoredUrl = new ArrayList<>();

}
