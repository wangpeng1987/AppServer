package servlet.user;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import servlet.base.BaseServlet;
import servlet.model.ResponseModel;
import servlet.user.db.UserDb;
import servlet.user.model.LoginReq;
import servlet.user.model.UserBean;
import servlet.util.JDBCUtils;
import servlet.util.JSONUtils;
import servlet.util.LOG;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static servlet.util.ErrorCodeUtils.*;

@WebServlet(name = "Login", urlPatterns = "/user/login")
public class Login extends BaseServlet {
    private final String TAG = "Login";

    @Override
    public String doPost(String json, HttpServletResponse resp) throws IOException {
        LOG.E(TAG, " 登录 req 数据： " + json);
        LoginReq loginReq = JSONUtils.fromJson(json, LoginReq.class);
        String name = loginReq.getUsername(); // 从 request 中获取名为 account 的参数的值
        String password = loginReq.getPassword();
        LOG.E(TAG, " 登录 ： " + "name:" + name + "\n password:" + password);

        ResponseModel responseModel = new ResponseModel();

        String msg = "";
        if (name.isEmpty()) {
            msg = "用户名为空！";
            responseModel.getError().setCode(CODE_10000);
        } else if (password.isEmpty()) {
            msg = "密码为空！";
            responseModel.getError().setCode(CODE_10001);
        } else {
            QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
            String sql5 = UserDb.SelectUser(name);
            try {
                UserBean userBean = runner.query(sql5, new BeanHandler<>(UserBean.class));
                if (userBean != null) {
                    if (password.endsWith(userBean.getPassword())) {
                        msg = "登陆成功！";
                        responseModel.setCode(200);
                        userBean.setPassword("");
                        responseModel.setData(userBean);
                    } else {
                        responseModel.getError().setCode(CODE_10003);
                        msg = "用户名密码不匹配，登录失败！";
                    }
                } else {
                    msg = "不存在此用户！";
                    responseModel.getError().setCode(CODE_10004);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                msg = e.getMessage();
                responseModel.getError().setCode(CODE_10002);
            }
        }
        responseModel.getError().setMsg(msg);

        String res = JSONUtils.toJson(responseModel);
        LOG.E(TAG, " 登录 结果  res ： " + res);
        return res;
    }
}
