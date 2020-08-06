package cn.yt4j.security.config;

import cn.net.lyjc.security.filter.JwtAuthenticationTokenFilter;
import cn.net.lyjc.security.property.JwtAuthFilterProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shichenyang
 */
@Slf4j
@EnableWebSecurity
public class MedicalSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtAuthFilterProperty jwtAuthFilterProperty;

    @SneakyThrows
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder);
    }

    @SneakyThrows
    @Override
    public void configure(WebSecurity web) {

        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/user/login")
                .antMatchers("/user/logout")
                .antMatchers("/user/sso")
                .antMatchers("/user/getUserPhone")
                .antMatchers("/city/**")
                .antMatchers("/user/getDoctName")
                .antMatchers("/dict/**")
                .antMatchers("/outpatinfo/selectAll")
                .antMatchers("/io/upload")
                .antMatchers("/io/download")
                .antMatchers("/dept/**")
                .antMatchers("/js/**.js")
                .antMatchers("/css/fonts/**.ttf")
                .antMatchers("/css/fonts/**.woff")
                .antMatchers("/img/**.png")
                .antMatchers("/css/**.css")
                .antMatchers("/plugins/**.exe")
                .antMatchers("/doc.html/**")
                .antMatchers("/v2/api-docs")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/webjars/**");

        if (!jwtAuthFilterProperty.getExcludeUrl().isEmpty()){
            String [] excludeUrl=jwtAuthFilterProperty.getExcludeUrl().split(",");
            for (String item:excludeUrl){
                web.ignoring().antMatchers(item);
            }
        }
    }

    /**
     * HTTP请求安全处理
     * token请求授权
     *
     * @param http .
     * @throws Exception .
     */
    @SneakyThrows
    @Override
    protected void configure(HttpSecurity http) {

        http.csrf().disable()
                //未授权处理
                .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            log.error("{}", authException.getMessage());

            Map<String,Object> result = new HashMap();
            result.put("code",401);
            result.put("message","未经授权");
            response.setContentType("application/json;charset=utf-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setStatus(HttpStatus.OK.value());
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().print(mapper.writeValueAsString(result));
        })

                // 基于token，所以不需要session
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        // 添加JWT filter
        //将token验证添加在密码验证前面
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        http.headers().cacheControl();
    }


}
