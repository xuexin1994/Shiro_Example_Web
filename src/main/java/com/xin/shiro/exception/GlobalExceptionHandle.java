package com.xin.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author xuexin
 * @date 2018/2/22
 */
public class GlobalExceptionHandle extends AbstractHandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        CustomerException customerException =null;
        ModelAndView mv = new ModelAndView();
        /*if (ex instanceof AuthenticationException){
            mv.addObject("error", ex.getClass().getName()+"-->"+ex.getMessage());
            mv.setViewName("login");
            return mv;
        }else*/ if(ex instanceof CustomerException){//1.判断是否是预期的异常还是运行时的异常
            //2.如果是预期的异常则直接返回信息
            customerException = (CustomerException)ex;
        }else{//3.如果是运行时的异常
            try {
                //4.将异常信息写入日志，发短信或邮件给相关人员
                StringWriter writer = new StringWriter();
                PrintWriter s = new PrintWriter(writer);
                ex.printStackTrace(s);
                System.out.println("写入日志》》》"+writer.toString());
//                MailUtil.sendMail(MailUtil.RECEIVER, ex.getMessage(), writer.toString());
            } catch (Exception e) {
                System.out.println("邮件发送失败");
            }
            //5.给用户一个友好提示，例如提示用户网络问题
            customerException= new CustomerException("网络异常(异常原因已发送至开发人员邮箱)");
        }
        mv.addObject("message", customerException.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
