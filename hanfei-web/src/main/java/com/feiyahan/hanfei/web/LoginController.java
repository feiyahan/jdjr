package com.feiyahan.hanfei.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanfei7 on 2016/12/23.
 */
@Controller
public class LoginController {

    private final static Logger logger= LoggerFactory.getLogger(IndexController.class);
    /**
     * 登录GET请求
     * */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView toLoginPage(HttpServletRequest request, ModelAndView modelAndView){
        logger.info("to login page method");
        return modelAndView;
    }

    /**
     * 登录POST请求
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginAuth(HttpServletRequest request,ModelAndView modelAndView){
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        logger.info("login exception {}",exceptionClassName);
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名不存在";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(LockedAccountException.class.getName().equals(exceptionClassName)){
            error = "账户已锁定";
        }else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码输入错误次数太多";
        }else if(AuthenticationException.class.getName().equals(exceptionClassName)){
            error = "您没有权限";
        }else if(exceptionClassName != null) {
            error = "未知错误：" + exceptionClassName;
        }
        if(StringUtils.isEmpty(error)){
            logger.info("登录成功");
            return modelAndView;
        }else {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("redirect:/login");
            logger.info("登录失败");
            return modelAndView;
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        logger.info("currentUser {}",currentUser);
        logger.info("session {}",currentUser.getSession());
        if (null != currentUser && currentUser.getSession() != null){
            logger.info("currentUser {} logout");
            currentUser.logout();
        }
        return "redirect:/login";
    }
    /**
     * 错误页面
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/error")
    public ModelAndView toError(HttpServletRequest request,ModelAndView modelAndView){
        return modelAndView;
    }
    /**
     * 未经授权页面
     * @return
     */
    @RequestMapping(value = "/unauthorized")
    public ModelAndView toUnauthorized(ModelAndView modelAndView){
        logger.info("用户登录未授权页面");
        return modelAndView;
    }
}
