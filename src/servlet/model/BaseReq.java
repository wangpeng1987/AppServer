package servlet.model;

public class BaseReq {


    /**
     * data : {"avatar":"http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg","email":"40666@qq.com","mcc":"86","password":"wwwwww","phone":"13089897878","username":"WANGPENG1"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
