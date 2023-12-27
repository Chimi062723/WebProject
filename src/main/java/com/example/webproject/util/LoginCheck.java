package com.example.webproject.util;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheck implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        //不需要请求处理的请求路径
        String [] urls=new String[]{
                "/webweb_war/login.jsp",
                "/webweb_war/forgot_password.jsp",
                "/webweb_war/register.jsp",
                "/webweb_war/",
                "/webweb_war/login",
                "/webweb_war/forgotPassword",
                "/webweb_war/register",
                "/webweb_war/logout",
                "/webweb_war/res/logo.png",
                "/webweb_war/res/logo_icon.png",
                "/webweb_war/res/background.png",
                "/webweb_war/css/login_register_forgetpassword.css",
                "/webweb_war/logout"
        };
        boolean check =check(urls,requestURI);
        if(check){
            filterChain.doFilter(request,response);
        }
        if(request.getSession().getAttribute("username")!=null){
            filterChain.doFilter(request, response);
        }else{
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    private boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if(url.equals(requestURI)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
