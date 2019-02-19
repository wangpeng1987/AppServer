package servlet.util;

import com.sun.tools.javac.util.Log;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class ParameterUtils {

    /**
     * 从body中获取参数
     *
     * @param request
     * @return
     */
    public static String getBodyData(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuffer data = new StringBuffer();
        try {
            String line = "";
            reader = request.getReader();
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            Log.format("get request params error: ", e);
        } finally {
            if (null == reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.format("close BufferedReader error: ", e);
                }
            }
        }
        return data.toString();
    }

}
