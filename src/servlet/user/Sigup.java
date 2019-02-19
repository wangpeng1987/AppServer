package servlet.user;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import servlet.base.BaseServlet;
import servlet.model.ResponseModel;
import servlet.user.db.UserDb;
import servlet.user.model.SigupReq;
import servlet.user.model.UserBean;
import servlet.util.JDBCUtils;
import servlet.util.JSONUtils;
import servlet.util.LOG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

import static servlet.util.ErrorCodeUtils.*;

@WebServlet(name = "SigupReq", urlPatterns = "/user/sigup")
public class Sigup extends BaseServlet {
    private final String TAG = "SigupReq";

    @Override
    public void doPost(String json, HttpServletResponse resp)  throws   IOException  {
        LOG.E(TAG, " 注册 req 数据： " + json);
        SigupReq sigupReq = JSONUtils.fromJson(json, SigupReq.class);
        String name = sigupReq.getData().getUsername(); // 从 request 中获取名为 account 的参数的值
        String password = sigupReq.getData().getPassword();
        LOG.E(TAG, " 注册 ： " + "name:" + name + "\n password:" + password);

        ResponseModel responseModel = new ResponseModel();

        String msg = "数据库读取异常！";
        if (name.isEmpty()) {
            msg = "用户名为空！";
            responseModel.getError().setCode(CODE_10000);
        } else if (password.isEmpty()) {
            msg = "密码为空！";
            responseModel.getError().setCode(CODE_10001);
        } else {
            UserBean userBean = getUser(name);
            if (userBean != null && name.endsWith(userBean.getUsername())) {
                msg = "用户名存在，注册失败！";
                responseModel.getError().setCode(CODE_10006);
            } else {
                QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
                try {
                    String uuid = UUID.randomUUID().toString();   //转化为String对象
                    uuid = uuid.replace("-", "");

                    String sql = UserDb.InsertUser();
                    Object[] params = new Object[]{uuid, sigupReq.getData().getUsername(), sigupReq.getData().getPassword(), sigupReq.getData().getAvatar(), sigupReq.getData().getPhone(), sigupReq.getData().getMcc(), sigupReq.getData().getEmail()};
                    int ren = runner.update(sql, params);

                    if (ren != 0) {
                        msg = "注册成功！";
                        responseModel.setCode(200);
                        responseModel.setData(getUser(name));
                    } else {
                        msg = "注册失败！";
                        responseModel.getError().setCode(CODE_10005);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    msg = e.getMessage();
                    responseModel.getError().setCode(CODE_10002);
                }
            }
        }
        responseModel.getError().setMsg(msg);

        String res = JSONUtils.toJson(responseModel);
        LOG.E(TAG, " 注册 结果  res ： " + res);

        resp.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式(否则中文乱码)
        PrintWriter pw = resp.getWriter(); // 获取 response 的输出流
        pw.println(res); // 通过输出流把业务逻辑的结果输出
        pw.flush();
    }

    private UserBean getUser(String name) {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql5 = UserDb.SelectUser(name);
        try {
            UserBean userBean = runner.query(sql5, new BeanHandler<UserBean>(UserBean.class));
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}