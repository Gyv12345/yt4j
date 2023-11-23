package cn.yt4j.web.config;

import cn.yt4j.core.constant.TracingConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 *
 * @author gyv12345@163.com
 */
@RequiredArgsConstructor
@Component
public class TracingFilter  extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId=request.getHeader(TracingConstants.TRACE_ID);
        MDC.put(TracingConstants.TRACE_ID, traceId);
        filterChain.doFilter(request, response);
    }
}
