package com.lenovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    @RequestMapping:
        value：所有请求地址的公共部分，叫做模块名称
        位置：放在类的上面
 */

@Controller
@RequestMapping(value = "/test")
public class MyController {

    /*
        属性：method，表示请求的方式。它的值RequestMethod类枚举值。
            列如表示get请求方式，RequestMethod.GET
            post方式,RequestMethod.POST
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","欢迎使用springMVC做web开发");
        modelAndView.addObject("fun","执行的是doSome方法");

        modelAndView.setViewName("show");
        return modelAndView;
    }
}
