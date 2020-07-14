package model;

/**
 * @author 黄建军
 * @version V1.0
 * @Package model
 * @date 2020/7/13 13:55
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class Requst {
    private  String key="free";
    private  String appid="0";
    private  String msg="";

    public Requst() {
    }

    public Requst(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
