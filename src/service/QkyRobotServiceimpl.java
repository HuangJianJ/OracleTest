package service;

import Util.HttpUtils;
import com.google.gson.Gson;
import model.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 黄建军
 * @version V1.0
 * @Package service
 * @date 2020/7/13 13:59
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class QkyRobotServiceimpl implements RobotService {

    private static final String apiTpl = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";

    private static final Gson gson=new Gson();

    @Override
    public Response qa(String msg)  {
        String api = null;
        try {
            api = String.format(apiTpl, URLEncoder.encode(msg,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = HttpUtils.request(api);
        Response response=null;
        if (msg!=null||"".equalsIgnoreCase(msg)){
             response=gson.fromJson(result,Response.class);
            return response;
        }else {
            response.setContent("您输入的有误，请从新输入");
        }
        return response;
    }
}
