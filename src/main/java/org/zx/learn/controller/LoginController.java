package org.zx.learn.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.service.UserService;

/**
 * Created by xiang zeng on 2017/10/1.
 */
@Controller
public class LoginController extends BaseController{

    @Autowired
    private UserService  userService;
    private  Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        logger.info("check login.......");
        ModelAndView modelAndView = new ModelAndView();
        if (SecurityUtils.getSubject().isAuthenticated()) {
            modelAndView.addObject("menuList",userService.listAllMenu());
            modelAndView.setViewName("/admin/admin");;
        }else{
            String exceptionName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
            if(exceptionName != null && !"".equals(exceptionName)){
                if (exceptionName.contains("UnknownAccountException")){
                    modelAndView.addObject("msg","账户不存在");
                } else if (exceptionName.contains("AccountException")) {
                    modelAndView.addObject("msg","账号异常");
                } else if (exceptionName.contains("IncorrectCredentialsException")){
                    modelAndView.addObject("msg","密码错误");
                }
            }
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "logout success";
    }

    @RequestMapping(value = "/loginWeb")
    public ResponseEntity<ResultEntity> loginWeb(HttpServletRequest request) {
        logger.info("check login.......");
        if (SecurityUtils.getSubject().isAuthenticated()){
            return buildSuccessResult();
        }
        else {
            String exceptionName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
            if (exceptionName != null && !"".equals(exceptionName)) {
                if (exceptionName.contains("UnknownAccountException")) {
                    return buildErrorResult(10, "账号不存在");
                } else if (exceptionName.contains("AccountException")) {
                    return buildErrorResult(11, "账号异常");
                } else if (exceptionName.contains("IncorrectCredentialsException")) {
                    return buildErrorResult(12, "密码错误");
                }
            }
            return buildErrorResult(13,"请先登录");
        }
    }
    @ResponseBody
    @RequestMapping("/checkPermission")
    @RequiresPermissions("user:create")
    public String permissions()
    {

        return "has permissions";

    }

    @ResponseBody
    @RequestMapping("/checkPermissionA")
    @RequiresPermissions("user:update")
    public String permissionsA()
    {
        return "has permissionsA";
    }
}

