package com.lenovo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenovo.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView，实现转发forward
     * 语法：setViewName("forward:视图文件完整路径")
     * forward特点：不和视图解析器一同使用，就当项目中没有视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("doSome , name= " + name + ", age = " + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发，可以访问视图解析器(view目录)之外的
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /**
     * 处理器方法返回ModelAndView，实现重定向redirect
     * 语法：setViewName("redirect:视图完整路径")
     * redirect特点：不和视图解析器一同使 用，就当项目中没有视图解析器
     * @param name
     * @param age
     * @return
     *
     * 框架对重定向的作用
     * 1.框架会把model中的简单类型数据，转为S挺使用，作为hello.jsp的get请求参数
     * 目的是在doRedirect.do和hello.jsp两次请求之间传递数据
     *
     * 2.在目标hello.jsp页面可以使用参数集合对象${param}获取请求参数值
     *
     * 3.重定向不能访问/WEB-INF资源
     */

    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        System.out.println("doRedirect , name= " + name + ", age = " + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //重定向
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }
}