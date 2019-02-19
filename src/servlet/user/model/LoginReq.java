package servlet.user.model;

/**
 * 登录上传数据
 */
public class LoginReq {

    /**
     * data : {"name":"WANG","password":"peng"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : WANG
         * password : peng
         */

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String name) {
            this.username = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
