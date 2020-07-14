package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 黄建军
 * @version V1.0
 * @Package Test
 * @date 2020/7/10 17:08
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class UrlConnectionTest {
    public static void main(String[] args) throws IOException {
        String Urls="https://api.xdclass.net:443/pub/api/v1/web/index_card?type=2";
        URL url=new URL(Urls);
        System.out.println("getPath="+url.getPath());
        System.out.println("getQuery="+url.getQuery());
        System.out.println("getFile="+url.getFile());
        System.out.println("getHost="+url.getHost());
        System.out.println("getPort="+url.getPort());
        System.out.println("getAuthority="+url.getAuthority());
        System.out.println("getProtocol="+url.getProtocol());

        //发送请求
       HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
       //获取响应码
       int responseCode= httpURLConnection.getResponseCode();
       //成功响应码为200
       if (responseCode>=200&&responseCode<=290){
           //获取响应的输入流，并打印到控制台
           try (InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader in= new BufferedReader(new InputStreamReader(inputStream))){
                StringBuilder stringBuilder=new StringBuilder();
                String currenLine;
               while ((currenLine=in.readLine())!=null) {
                   stringBuilder.append(currenLine);
               }
               System.out.println(stringBuilder.toString());
           }catch (Exception e){
               e.printStackTrace();
           }
       }

    }
}
