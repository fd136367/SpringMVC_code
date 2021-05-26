package com.lenovo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenovo.exception.AgeException;
import com.lenovo.exception.MyUserException;
import com.lenovo.exception.NameException;
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

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException  {
        System.out.println("doSome , name= " + name + ", sage = " + age);
        //根据请求参数抛出异常
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }

        if (age > 80 || age == null){
            throw new AgeException("年龄比较大");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

}