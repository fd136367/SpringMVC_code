package com.lenovo.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器方法：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {

    private long dtime = 0;
    private long etime = 0;
    /**
     * preHandler叫做预处理方法
     *  重要：是整个项目的入口，门户。当preHandler返回true请求可以被处理
     *      preHandle返回false，请求到此方法就截止
     * @param request
     * @param response
     * @param handler 被拦截的控制器对象
     * @return 返回值boolean
     *  true:请求时通过了拦截器的验证，可以执行处理器方法
     *      拦截器MyInterceptor的preHandle方法执行了
     *      拦截器MyInterceptor的doSome方法执行了
     *      拦截器MyInterceptor的postHandle方法执行了
     *      拦截器MyInterceptor的afterCompletion方法执行了
     *
     *  false:请求没有通过拦截器的验证，请求到达拦截器就停止了。请求没有被处理
     *      拦截器MyInterceptor的preHandle方法执行了
     * @throws Exception
     * 特点：1.是在控制器方法(MyController的doSome方法)执行之前先执行的
     *  用户的请求首先到达此方法
     *  2.在这个方法中可以获取请求的信息，验证请求是否符合要求。
     *  可以验证用户是否登录，验证用户是否有权限访问某个链接地址（url）
     *      如果验证失败，可以截断请求，请求不能被处理
     *      如果验证成功，可以放行请求，此时控制器方法才能执行
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器MyInterceptor的preHandle方法执行了");
        dtime = System.currentTimeMillis();
        //给浏览器一个返回结果
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    /**
     * postHandle:后处理方法
     * @param handler 被拦截的处理器对象MyController
     * @param modelAndView 处理器方法的返回值
     *  特点：1.在处理器方法之后执行的（MyController.doSome()）
     *       2.能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，可以影响到最后的执行结果
     *       3.主要是对原来的执=执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器MyInterceptor的postHandle方法执行了");
        //对原来的doSome执行结果需要调整
        if (modelAndView != null){
            //修改数据
            modelAndView.addObject("mydate",new Date());
            //修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion：最后执行的方法
     * @param handler 被拦截的处理对象
     * @param ex    程序中发生的异常
     *   特点：
     *       1.在请求处理完成之后执行的。框架中规定是当你的视图完成后，对视图执行了forward，就认为是请求处理完成
     *       2.一般是做资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        etime = System.currentTimeMillis();
        System.out.println("拦截器MyInterceptor的afterCompletion方法执行了");
        System.out.println("拦截器的执行时间是"+(etime - dtime));
    }
}
