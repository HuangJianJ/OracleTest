package model;

/**
 * @author 黄建军
 * @version V1.0
 * @Package model
 * @date 2020/7/13 13:57
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class Response{
    private  int code;
    private  String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
