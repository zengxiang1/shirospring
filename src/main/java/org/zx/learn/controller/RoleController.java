package org.zx.learn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zx.learn.dto.SysRoleDTO;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.service.RoleService;

/**
 * Created by xiang zeng on 2017/10/27.
 *
 * @author xiang zeng
 */
@Controller
@RequestMapping("/resource/role")
public class RoleController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @RequestMapping
    public ModelAndView toRoleView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/sys/role");
        return modelAndView;
    }

    @RequestMapping( value = "/list",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<ResultEntity> listAllRole() {
        List<SysRoleDTO> sysRoleDTOS = roleService.listAllRole();

        return buildSuccessResult(sysRoleDTOS);
    }
    @RequestMapping(value = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<ResultEntity> delete(@RequestBody List<SysRoleDTO> sysRoleDTOS){
        List<Integer> ids = new ArrayList<Integer>();
        for (SysRoleDTO sysRoleDTO : sysRoleDTOS) {
            ids.add(sysRoleDTO.getId());
        }
        roleService.deleteRoleById(ids);
        return buildSuccessResult();
    }
}
