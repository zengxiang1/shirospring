package org.zx.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zx.learn.entity.ResultEntity;
import org.zx.learn.exception.ServiceException;

/**
 * Created by xiang zeng on 2017/10/30.
 *
 * @author xiang zeng
 */
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);
    public  ResponseEntity<ResultEntity> buildSuccessResult(Object object){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(0);
        resultEntity.setMsg("成功");
        resultEntity.setData(object);
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);
    }


    public  ResponseEntity<ResultEntity> buildSuccessResult(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(0);
        resultEntity.setMsg("success");
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);
    }

    public  ResponseEntity<ResultEntity> buildExceptionResult(ServiceException serviceException){
        ResultEntity resultEntity = new ResultEntity(serviceException.getErrorCode(), serviceException.getErrorMsg());
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ResultEntity> handlerException(Exception ex){
        ResultEntity resultEntity = null;
        if (ex instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) ex;
            resultEntity = new ResultEntity(serviceException.getErrorCode(), serviceException.getErrorMsg());
        } else {
            resultEntity = new ResultEntity(1, ex.getMessage());
        }
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);
    }
    public ResponseEntity<ResultEntity> buildErrorResult(Integer code, String msg){
        ResultEntity resultEntity = new ResultEntity(code, msg);
        return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);

    }
}
