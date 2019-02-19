package servlet.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.Expose;

/**
 * @title ResponseModel
 */
public class ResponseModel<T> {

    @Expose
    private int code = 0;

    @Expose
    private T data;

    @Expose
    private ErrorModel error = new ErrorModel();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}
