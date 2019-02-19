package servlet.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import servlet.model.BaseEncode;
import servlet.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static servlet.util.ContantUtils.ENCODE_VALUE_TRUE;
import static servlet.util.ContantUtils.HEAD_KEY_UP_ENCODE;

//@WebServlet(name = "SigupReq", urlPatterns = "/user/sigup")
public abstract class BaseServlet extends HttpServlet {
    private final String TAG = "BaseServlet";
    //加解密需要的key
    public static final String AES256_KEY = "ilc2grp9_d3LcMRYJ8BgYsSXuvnQbHbH==";

    @Override
    final protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    final protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    final protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = ParameterUtils.getBodyData(req);
        String upEncode = req.getHeader(HEAD_KEY_UP_ENCODE);
//        String result = "";
        if (ENCODE_VALUE_TRUE.equals(upEncode)) {
            //请求的参数加密
            String encodeParams = encodeParams(json);
            doPost(encodeParams, resp);
        } else {
            doPost(json, resp);
        }
    }

    @Override
    final protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    final protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    final protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    @Override
    final protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDefault(req, resp);
    }

    private void doDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "hello world!";
        resp.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式(否则中文乱码)
        PrintWriter pw = resp.getWriter(); // 获取 response 的输出流
        pw.println(msg); // 通过输出流把业务逻辑的结果输出
        pw.flush();
    }

    /**
     * 将params中data包含的数据加密
     *
     * @param params
     * @return
     */
    final private String encodeParams(String params) {
        BaseEncode baseEncode = JSONUtils.getPerson(params, BaseEncode.class);
        String dataStr = baseEncode.getData();
        String encodeStr = EncodeUtil.decode(AES256_KEY, dataStr);
        baseEncode.setData(encodeStr);
        return JSONUtils.toJson(baseEncode);
    }

    public abstract void doPost(String reqJson, HttpServletResponse resp) throws IOException;

}