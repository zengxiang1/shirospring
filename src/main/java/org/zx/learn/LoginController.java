package org.zx.learn;

import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiang zeng on 2017/10/1.
 */
@Controller
public class LoginController {
    private  Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        logger.info("check login......");
        ModelAndView modelAndView = new ModelAndView();
        if (SecurityUtils.getSubject().isAuthenticated()) {
            modelAndView.setViewName("/admin/admin");;
        }else{
            String exceptionName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
            if (exceptionName.contains("UnknownAccountException")){
                modelAndView.addObject("msg","账户不存在");
            } else if (exceptionName.contains("AccountException")) {
                modelAndView.addObject("msg","账号异常");
            } else if (exceptionName.contains("IncorrectCredentialsException")){
                modelAndView.addObject("msg","密码错误");
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

