package servlet.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.Expose;

/**
 * @title ErrorModel
 */
public class ErrorModel {

    @Expose
    private int code;
    @Expose
    private String msg;

    public ErrorModel() {
    }

    public ErrorModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
