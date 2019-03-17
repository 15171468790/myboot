package com.example.myboot.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 实现方法二，JDK注解
 */
//@WebFilter(urlPatterns="/*")
//@Order(3)
public class Myfilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("第二个过滤器哈哈");
        filterChain.doFilter(servletRequest,servletResponse);
        //System.out.println("第san个过滤器哈哈");
    }

    @Override
    public void destroy() {

    }
}
