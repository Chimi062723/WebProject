package com.example.webproject.filter;

import com.example.webproject.wrapper.MyRequest;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "wordFilter", urlPatterns = "/*")
public class WordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        MyRequest myRequest = new MyRequest(request);
        filterChain.doFilter(myRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
