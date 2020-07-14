package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 拷贝文件下面的所有目录，并创建另外一个文件夹
 */
public class IoCopyMkdirs {
    public static void main(String[] args) {
        String dir="C:\\Users\\jj\\Desktop";
        File file=new File(dir+File.separator+"mack");
        //获取该文件夹下面的所有文件
        File [] files=file.listFiles();
        for (File forem:files){
            //获取文件夹下面的所有文件名
            String fileName=forem.getName();
            copy(forem.getAbsolutePath(),dir+File.separator+"mackes"+File.separator+fileName);
        }

    }

    public static void copy(String absoluteFile, String to) {
        try {
            //拿到dir这一层的目录，看看有没有一样的文件夹存在
            File tarFile=new File(new File(to).getParent());
            System.out.println(new File(to).getParent());
            //不存在则创建
            if(!tarFile.exists()){
                tarFile.mkdirs();
            }
            //用文件输入流
            FileInputStream fis=new FileInputStream(absoluteFile);
            //包装
            BufferedInputStream bis=new BufferedInputStream(fis);

            //文件输出流
            FileOutputStream fos=new FileOutputStream(to);
            //包装
            BufferedOutputStream bos=new BufferedOutputStream(fos);

            //定义文件大小，并用数组装入
            int size;
            byte [] bytes =new byte[1024];
            //bis.read(),读取文件到最后返回-1
            while ((size=bis.read(bytes))!=-1) {
                //输出也就是写入copy
                 bos.write(bytes,0,size);
            }
            //刷新输出流,JDK1.7新特性不需要加
            //bos.flush();
            bis.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
