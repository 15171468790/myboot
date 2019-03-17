package com.example.myboot.filter;

import com.example.myboot.common.MyThredLocal;
import com.example.myboot.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器实现方法一
 */
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response  = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        User user = new User();
        user.setPass(url);
        MyThredLocal.setValue(user);
        System.out.println("111");
       // request.getRequestDispatcher("/").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/");
        filterChain.doFilter(request,response);
        System.out.println("12222");
    }

    @Override
    public void destroy() {

    }
}
