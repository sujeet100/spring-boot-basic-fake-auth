package com.oauth.basic;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;

        final HttpServletRequestWrapper reqWrapper = new HttpServletRequestWrapper(req) {

            @Override
            public String getHeader(String name) {
                if (HttpHeaders.AUTHORIZATION.equals(name)) {
                    String username = req.getHeader("username");
                    String auth = username + ":" + username;
                    System.out.println("============================");
                    System.out.println(auth);
                    System.out.println("============================");
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII), false);
                    return "Basic " + new String(encodedAuth);
                }
                return super.getHeader(name);
            }
        };
        chain.doFilter(reqWrapper, response);
    }

}

