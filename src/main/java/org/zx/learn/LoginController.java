package org.zx.learn;

import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiang zeng on 2017/10/1.
 */
@Controller
public class LoginController {
    private  Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        logger.info("check login......");
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "/admin/admin";
        }else{
            return "/login";
        }
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

