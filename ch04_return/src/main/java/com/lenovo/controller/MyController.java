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

    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest  request, String name, Integer age){
        System.out.println("doReturnView , name= "+name+", age = "+age);
        //可以自己手动添加数据到request作用域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        //show:逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }
    //retuenVoid-ajax.do
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("doReturnAjax , name= "+name+", age = "+age);
//            处理ajax，使用json做数据的格式
//        service调用完成了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        //把结果的对象转为json格式
        if (student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json=="+json);
        }
        //输出数据，相应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();

    }

    /*
    处理器方法返回一个Student，通过框架转为json，响应ajax请求
    @ResponseBody
            作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
            位置：方法我的定义上面。和其他注解没有顺序关系
     返回对象框架的处理流程
        1.框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWriter()方法
            检查那个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter

        2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的write()方法
            把李四同学的student对象转为json，调用Jackson的ObjectMapper实现转为json

        3.框架会调用@ResponseBody把2的结果数据输出到浏览器，Ajax请求处理完成
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(HttpServletResponse response, String name, Integer age) throws IOException {
        //调用service，获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        return student;
    }

    /*
        集合遍历
     */
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(HttpServletResponse response, String name, Integer age) throws IOException {
        //调用service，获取请求结果数据，Student对象表示结果数据
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        students.add(student);

        student = new Student();
        student.setName("张三");
        student.setAge(20);
        students.add(student);

        return students;
    }
    /*
        处理器方法返回的时String，String表示数据的，不是视图
        区分返回值String是数据，还是视图，看有没有@ResponseBody注解
        如果有，返回String就是数据，反之就是视图

        默认使用“text/html;charset=ISO-8859-1”作为contentType，导致中文有乱码
        解决方法：给RequestMapping增加一个属性produces，使用这个属性指定新的Context-type

     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }
}
