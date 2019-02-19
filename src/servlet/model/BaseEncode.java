package servlet.model;

import com.google.gson.annotations.Expose;

public class BaseEncode {

    /**
     * data : sXklQ45CMDSrKL+du11nfiGwrB/EHrBzapuKr5/5srnbZnIqp3FQPPIcsoxO5D8PHAY3/Djqk3QH
     * B28Ropt4C7GVrAXj/hVZ2h/w9U8j8ssWfkTy2VW7zdldJ/3Sj3Wzr1plRLccWCq7nSJqs4UvSycl
     * s+3Wymw6LPoarkf2qni9W+Zw4AMXfJPXAnlQm85n5Sbm95tl/o1iiP5IOJZWeiyFcp6YxFCTcSQQ
     * eVhe/70=
     */
    @Expose
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
