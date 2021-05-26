package com.lenovo.handler;

import com.lenovo.exception.AgeException;
import com.lenovo.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice：控制器增强（也就是说给控制器类增加功能--异常处理功能）
 *      位置：在类的上面
 *   特点：必须让框架知道这个注解所在的包名，需要在Springmvc配置文件中声明组件扫描器
 *   指定@ControllerAdvice所在的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法，处理发生的异常
    /*
        处理异常的方法和控制器的方法一样，可以有多个参数，可以有ModelAndView，
            String void，对象类型的返回值

         形参：Exception,表示Controller中抛出的异常对象
         通过形参可以获取发生的异常信息


         @ExceptionHandler(异常的class)：表示异常的类型，当发生此类型异常时，由当前方法处理

     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        //处理NameException的异常
        /*
            异常发生处理逻辑
                1.需要把异常记录下来，记录到数据库，日志文件
                记录异常发生的时间，那个方法发生的，异常错误内容
                2.发送通知，把异常的信息通过邮件，短信，微信发送给相关人员
                3.给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","姓名必须是zs，其他用户不能访问");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }

    //处理NameException的异常
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你的年龄不能大于80");
        mv.addObject("ex",exception);
        mv.setViewName("ageError");
        return mv;
    }

    //处理其他异常，name，age以外的不知类型的异常
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","出错了，等会再访问吧");
        mv.addObject("ex",exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
