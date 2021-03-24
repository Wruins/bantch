package com.Rowan.utils;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Author: Rowan
 * @Date: 2021/3/21 - 10:38
 * @Description: com.Rowan.utils
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override//请求前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String indexpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        if(session.getAttribute("user")==null){
//            request.getRequestDispatcher("/user/login").forward(request, response);
            response.sendRedirect(indexpath + "/user/login");
            return false;
        }else{
            return true;
        }
    }



}
