package servlet.user.model;

/**
 * 注册上传数据
 */
public class SigupReq {

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
        /**
         * avatar : http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg
         * email : 40666@qq.com
         * mcc : 86
         * password : wwwwww
         * phone : 13089897878
         * username : WANGPENG1
         */

        private String avatar;
        private String email;
        private String mcc;
        private String password;
        private String phone;
        private String username;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMcc() {
            return mcc;
        }

        public void setMcc(String mcc) {
            this.mcc = mcc;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
