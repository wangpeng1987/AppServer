package servlet.user;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import servlet.model.ResponseModel;
import servlet.user.db.UserDb;
import servlet.user.model.LoginReq;
import servlet.user.model.UserBean;
import servlet.util.JDBCUtils;
import servlet.util.JSONUtils;
import servlet.util.LOG;
import servlet.util.ParameterUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static servlet.util.ErrorCodeUtils.*;

@WebServlet(name = "Login", urlPatterns = "/user/login")
public class Login extends HttpServlet {
    private final String TAG = "Login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = ParameterUtils.getBodyData(req);
        LOG.E(TAG, " 登录 req 数据： " + json);
        LoginReq loginReq = JSONUtils.fromJson(json, LoginReq.class);
        String name = loginReq.getData().getUsername(); // 从 request 中获取名为 account 的参数的值
        String password = loginReq.getData().getPassword();
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
                UserBean userBean = runner.query(sql5, new BeanHandler<UserBean>(UserBean.class));
                if (userBean != null) {
                    if (password.endsWith(userBean.getPassword())) {
                        msg = "登陆成功！";
                        responseModel.setCode(200);
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

        String res = JSONUtils.toJson(responseModel).toString();
        LOG.E(TAG, " 登录 结果  res ： " + res);

        resp.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式
        PrintWriter pw = resp.getWriter(); // 获取 response 的输出流
        pw.println(res); // 通过输出流把业务逻辑的结果输出
        pw.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    private void doDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "hello world!";
        resp.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式(否则中文乱码)
        PrintWriter pw = resp.getWriter(); // 获取 response 的输出流
        pw.println(msg); // 通过输出流把业务逻辑的结果输出
        pw.flush();
    }

}
