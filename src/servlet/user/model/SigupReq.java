package servlet.user.model;

/**
 * 注册上传数据
 */
public class SigupReq {


    /**
     * password : wwwwww
     * phone : 13089897878
     * avatar : http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg
     * mcc : 86
     * email : 40666@qq.com
     * username : WANGPENG1
     */

    private String password;
    private String phone;
    private String avatar;
    private String mcc;
    private String email;
    private String username;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
