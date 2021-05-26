package com.lenovo.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //验证登录的用户信息，正确return tue 反之 false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1=====拦截器MyInterceptor的preHandle方法执行了====");
        String loginName = "";
        //从session中获取name的值
        Object attr = request.getSession().getAttribute("name");

        if (attr != null){
            loginName = (String)attr;
        }
        //判断登录账户，是否符合要求
        if (!"zs".equals(loginName)){
            //不能访问系统
            //给用户提示
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
        //zs登录
        return true;
    }

}
