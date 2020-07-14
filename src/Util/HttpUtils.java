package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 黄建军
 * @version V1.0
 * @Package Util
 * @date 2020/7/13 13:25
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class HttpUtils {
    public static String request(String api){
        HttpURLConnection httpURLConnection=null;
        int responseCode=0;
        String result=null;
        try {
            URL url=new URL(api);
            //获取对应的连接对象
            httpURLConnection= (HttpURLConnection) url.openConnection();
            //获取响应码
            responseCode=httpURLConnection.getResponseCode();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (200<=responseCode&&responseCode<=299){
            //获取输入流
            try (InputStream inputStream=httpURLConnection.getInputStream();
                 BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream))){
                //线程不安全的
                //StringBuilder response=new StringBuilder();
                //线程安全的
                StringBuffer response=new StringBuffer();
                String currentLine;
                while ((currentLine=bufferedReader.readLine())!=null) {
                    response.append(currentLine);
                }
                result= response.toString();
                return result;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
