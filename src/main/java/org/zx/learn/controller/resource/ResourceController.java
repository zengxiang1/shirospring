package org.zx.learn.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zx.learn.dto.SysResourceDTO;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.service.ResourceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiang zeng on 2017/11/29.
 *
 * @author xiang zeng
 */
@Controller
@RequestMapping("/resource/resource")
public class ResourceController extends BaseController{
    @Autowired
    private ResourceService resourceService;
    @RequestMapping( value = "/listTopResource",produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultEntity> listTopResource() {
        return buildSuccessResult(resourceService.listTopResource());
    }

    @RequestMapping( value = "/listByParent/{id}",produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultEntity> listTopResourceByParent(@PathVariable Integer id) {
        return buildSuccessResult(resourceService.listResourceByParent(id));
    }

    @RequestMapping( value = "/delete",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultEntity> deleteResource(@RequestBody List<SysResourceDTO> sysResourceDTOS) {
        List<Integer> ids = new ArrayList<Integer>();
        for (SysResourceDTO sysResourceDTO: sysResourceDTOS) {
            ids.add(sysResourceDTO.getId());
        }
        resourceService.deleteResource(ids);
        return buildSuccessResult();
    }
    @RequestMapping( value = "/update",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultEntity> updateResource(@RequestBody SysResourceDTO sysResourceDTO) {
        resourceService.saveResource(sysResourceDTO);
        return buildSuccessResult();
    }

    @RequestMapping( value = "/save",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultEntity> saveResource(@RequestBody SysResourceDTO sysResourceDTO) {
        resourceService.saveResource(sysResourceDTO);
        return buildSuccessResult();
    }

}
