package servlet.util;

public class ContantUtils {
    //代表参数是否加密：1->数据加密，0->数据不加密（只针对post方法）
    public static final String HEAD_KEY_UP_ENCODE = "up-encode";
    //代表接口返回的数据是都加密：1->数据加密，0->数据不加密（get和post方法通用）
    public static final String HEAD_KEY_DOWN_ENCODE = "down-encode";
    //代表数据加密，up_encode和down_encode通用
    public static final String ENCODE_VALUE_TRUE = "1";
    //代表数据不加密，up_encode和down_encode通用
    public static final String ENCODE_VALUE_FALSE = "0";
    //在需要参数加密的接口上面添加此动态head，用来标记对应接口参数需要加密
    public static final String HEAD_UP_ENCODE_TRUE = HEAD_KEY_UP_ENCODE + ": " + ENCODE_VALUE_TRUE;
    public static final String HEAD_UP_ENCODE_FALSE = HEAD_KEY_UP_ENCODE + ": " + ENCODE_VALUE_FALSE;
}
