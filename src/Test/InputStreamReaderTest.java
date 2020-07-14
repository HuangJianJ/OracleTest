package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 黄建军
 * @version V1.0
 * @Package Test 读取文件按照UTF-8读取
 * 字节流转换成字符流
 * @date 2020/7/9 8:53
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class InputStreamReaderTest {
    public static void main(String[] args)throws IOException {
      String path="C:\\Users\\jj\\Desktop\\战士专用宏.txt";
      test(path);
    }

    private static void test(String path) throws IOException {
        //读取字节流
        InputStream in = new FileInputStream(path);
        //将字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");
        //创建字符流缓冲区
        BufferedReader reader = new BufferedReader(isr);

        String tst;
        while ((tst = reader.readLine()) != null) {
            System.out.println(tst);
        }
        isr.close();
        reader.close();
    }
}
