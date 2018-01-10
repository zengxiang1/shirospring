package org.zx.learn.controller.resource;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.zx.learn.dto.AuthDTO;
import org.zx.learn.dto.UserDTO;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resource/user")
public class UserController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @RequestMapping
    public ModelAndView toUserView(){
        ModelAndView userView = new ModelAndView();
        userView.setViewName("/admin/sys/user");
        return userView;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public ResponseEntity<ResultEntity> getAllUser(){

        Map<String,String> paramsMap = new HashMap<>();
        List<UserDTO> resultList = userService.getAllUser(paramsMap);
        return buildSuccessResult(resultList);
    }

    @RequestMapping(value = "deleteUserInfo", consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<ResultEntity> deleteUserInfo(@RequestBody List<UserDTO> userDTOS){

        List<Integer> ids = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            ids.add(userDTO.getId());
        }
        userService.deleteUserInfoById(ids);
        return buildSuccessResult();
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultEntity> getUserInfo(){
        AuthDTO sysUser = (AuthDTO) SecurityUtils.getSubject().getPrincipal();
        UserDTO userDTO = userService.getUserById(sysUser.getUserId());
        return buildSuccessResult(userDTO);
    }
}
