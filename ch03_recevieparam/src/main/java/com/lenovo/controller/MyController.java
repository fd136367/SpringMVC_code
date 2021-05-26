package com.lenovo.controller;

import com.lenovo.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping(value = "/test")
public class MyController {
    /*
        接收请求的参数，使用处理器方法的形参
        1)HttpServletRequest
        2)HttpServletResponse
        3)HttpSession
        4)用户提交的数据

        逐个接收请求参数
            要求：处理器（控制器）方法的形参名和请求中参数名必须一致
            同名的请求参数赋值给同名的形参
         框架接收请求参数
            1.使用request对象接收请求参数
                String strName = request.getParameter("name");
                String strAge = request.getParameter("age");
            2.SpringMVC框架通过DispatcherServlet调用MyController的doSome方法
                调用方法时，按照名称，把接收的参数赋值给形参
                doSome(strName,Integer.valueOf(strAge))
                框架会提供类型转换的功能，能把String转为int,long,float,double 等类型
     */
    @RequestMapping(value = "/receiveProperty.do")
    //可以在方法中直接使用name，age
    public ModelAndView doSome(String name, Integer age){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);

        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 请求中参数名和处理器方阿飞的形参名不一样
     * @RequestParam:逐个接收请求参数中，解决请求中参数名形参名不一样的问题
     *      属性：1.value 请求中的参数名称
     *          2.required是一个boolean，默认是true
     *                     true：表示请求中必须包含此参数
     *      位置：在处理器方法的形参定义的前面
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String name,
                                     @RequestParam(value = "rage",required = false) Integer age){
        System.out.println("doSome,name="+name+"   age"+age);

        //可以在方法中直接使用 name ， age
        //处理some.do请求了。相当于service调用处理完成了

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);

        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 处理器方法形参是java对象，这个对象的属性名和请求中参数名一样的
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveObject(Student myStudent){
        System.out.println("doSome,name="+myStudent.getName()+"   age"+myStudent.getAge());

        //可以在方法中直接使用 name ， age
        //处理some.do请求了。相当于service调用处理完成了

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("myName",myStudent.getName());
        modelAndView.addObject("myAge",myStudent.getAge());
        modelAndView.addObject("mystudent",myStudent);

        modelAndView.setViewName("show");
        return modelAndView;
    }
}
