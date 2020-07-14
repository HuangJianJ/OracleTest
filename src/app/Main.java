package app;

import model.Response;
import service.QkyRobotServiceimpl;
import service.RobotService;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @author 黄建军
 * @version V1.0
 * @Package app
 * @date 2020/7/13 14:01
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class Main {

    private static  final RobotService robotService=new QkyRobotServiceimpl();
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        System.out.println("老板麻烦给我取一个响亮点的名称，按回车确定！");
        String name=scanner.nextLine();
        System.out.println("我是你的小助手:"+name+",直接对我下达命令");
        while (true){
            String msg=scanner.nextLine();
            if ("886".equalsIgnoreCase(msg)){
                System.out.println("欢迎下次使用，拜拜！");
                break;
            }else {
                //在业务层已经做了非空判断
               Response response= robotService.qa(msg);
              if (response.getCode()==0&&response!=null){
                  String flse= null;
                  try {
                      //防止乱码
                      flse = new String(response.getContent().getBytes(),"UTF-8");
                  } catch (UnsupportedEncodingException e) {
                      e.printStackTrace();
                  }
                  System.out.println(name+":"+flse);
              }
            }
        }
        scanner.close();
    }
}
