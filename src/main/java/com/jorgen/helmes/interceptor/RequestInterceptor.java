package com.jorgen.helmes.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class RequestInterceptor extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        log.info("Received request: {} with method: {} from: {}", request.getRequestURI(), request.getMethod(), getIp(request));
        filterChain.doFilter(requestWrapper, responseWrapper);

        log.info("Sent response: {}", new String(responseWrapper.getContentAsByteArray()));
        responseWrapper.copyBodyToResponse();
    }

    private String getIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-User-Ip");
        if (ipAddress != null) {
            return ipAddress.split(",")[0];
        }

        return request.getRemoteAddr();
    }
}

