package com.chb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        //放行：判断什么情况下登录
        //登录页面也会放行
        if(request.getRequestURI().contains("toLogin")){
            System.out.println("拦截器：toLogin通过");
            return true;
        }
        //说明在提交登录
        if(request.getRequestURI().contains("login")){
            System.out.println("拦截器：login通过");
            return true;
        }
        if(session.getAttribute("userLoginInfo")!=null){
            System.out.println("拦截器：userLoginInfo通过");
            return true;
        }
        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request,response);
        return false;
    }
}