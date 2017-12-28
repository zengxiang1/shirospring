package org.zx.learn.entity;

/**
 * Created by xiang zeng on 2017/10/30.
 *
 * @author xiang zeng
 */
public class ResultEntity {
    private Integer code;
    private String msg;
    private Object data;

    public ResultEntity() {
    }

    public ResultEntity(Integer code) {
        this.code = code;
    }

    public ResultEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
