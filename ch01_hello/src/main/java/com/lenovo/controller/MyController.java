package com.lenovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    创建处理器对象，对象放在springmvc容器中
    位置：在类的上面
    和spring中讲的@Service,@Compoent

    能处理请求的都是控制器（处理器）：MyController能处理请求，叫做后端控制器（back controller）
 */
@Controller
public class MyController {
    /*
        处理用户提交的需求，springmvc中是使用方法来处理的
        方法是自定义的，可能有多种返回值，多种参数，方法名称自定义
     */
    /*
        准备使用doSome方法处理somedo请求。
        @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起
        一个请求指定一个方法处理
            属性：1.value是一个String，表示请求的url地址（some.do）。
                    value的值必须是唯一的，不能重复。在使用时，推荐地址以“/”

            说明：使用ReqMapping修饰的方法叫做处理器方法或者控制器方法
            使用@ReqMapping修饰的方法可以处理请求的，类似Servler中的doGet，doGet

            返回值：ModelAndView 表示本次请求的处理结果
            Model：数据，请求处理完成之后，要显示给用户的数据
            View：视图，比如jsp等等
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){ //doGet()--service请求处理
        //处理some.do请求。相当于service调用处理完成了
        ModelAndView modelAndView = new ModelAndView();
        //添加数据，框架在请求的最后把数据放入到Request作用域
        //request.setAttribute("msg","欢迎使用springMVC做web开发");
        modelAndView.addObject("msg","欢迎使用springMVC做web开发");
        modelAndView.addObject("fun","执行的是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispatcher("/show.jsp").forward(...)
        //modelAndView.setViewName("/show.jsp");
        //modelAndView.setViewName("/WEB-INF/view/show.jsp");
        //框架会使用视图解析器的前缀+逻辑名称+后缀组成完成路径，这里就是字符链接操作
        ////WEB-INF/view/ + show + .jsp
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
