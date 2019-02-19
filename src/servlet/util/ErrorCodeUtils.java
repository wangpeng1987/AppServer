package servlet.util;

/**
 * Created by WOP on 2018/10/13.
 * 服务器 response 返回的 错误码
 */
public class ErrorCodeUtils {
    //login register
    public static final int CODE_10000 = 10000; //用户名为空！
    public static final int CODE_10001 = 10001; //密码为空！
    public static final int CODE_10002 = 10002; //数据库查询异常
    public static final int CODE_10003 = 10003; //用户名密码不匹配，登录失败！
    public static final int CODE_10004 = 10004; //不存在此用户！
    public static final int CODE_10005 = 10005; //注册失败
    public static final int CODE_10006 = 10006; //用户存在，注册失败
    public static final int CODE_10007 = 10007; //Params eamil not current
    public static final int CODE_10008 = 10008; //Params username invalidate
    public static final int CODE_10013 = 10013; //Params from must required
    public static final int CODE_10014 = 10014; //Email 和 username 已经被注册
    public static final int CODE_10015 = 10015; //Too many operations. Try again later.
    public static final int CODE_10016 = 10016; //Invalid phone number
    public static final int CODE_10017 = 10017; //Invalid phone code
    public static final int CODE_10018 = 10018; //Send code fail
    public static final int CODE_10019 = 10019; //User profile not found
    public static final int CODE_10020 = 10020; //User not found
    public static final int CODE_10021 = 10021; //Params avatar must be string
    public static final int CODE_10022 = 10022; //Param bio must be string
    public static final int CODE_10023 = 10023; //Param gender must be integer
    public static final int CODE_10024 = 10024; //Param scope must be integer
    public static final int CODE_10025 = 10025; //Param nickname must be string
    public static final int CODE_10026 = 10026; //User id is underfinde
    public static final int CODE_10027 = 10027; //User id must be integer
    public static final int CODE_10028 = 10028; //Params username has exist
    public static final int CODE_10029 = 10029; //Params username not allow empty
    public static final int CODE_10030 = 10030; //Params phone has exist
}
