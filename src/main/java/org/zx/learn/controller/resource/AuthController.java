package org.zx.learn.controller.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.service.AuthService;

@Controller
@RequestMapping("/resource/auth")
public class AuthController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    AuthService authService;

    @RequestMapping( value = "/checkAuth",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<ResultEntity> checkAuth(@RequestBody String authName){

        int result = authService.checkAuth(authName);
        log.info("校验用户名：authName:" + authName + "result:" + String.valueOf(result));
        if (result > 0){
            return buildErrorResult(-1,"用户名已存在！");
        }else{
            return buildSuccessResult(result);
        }
    }
}
