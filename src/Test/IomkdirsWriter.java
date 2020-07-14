package Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IomkdirsWriter{


    public static  void main(String... args ) throws IOException {
        String Pathath="C:\\Users\\jj\\Desktop";
        createDir(Pathath);
    }

    /**
     * 创建一个TEST文件夹，并在下面创建1-10文件夹，并在1-10文件夹下面创建1-10txt文件，
     * 并在1-10txt文件下面写入一段话
     * @param path
     * @throws IOException
     */
    public static void createDir(String path) throws IOException {

        //步骤1.先在桌面创建test文件夹，并判断该文件夹是否存在
        String root=path+ File.separator+"test";
        File rootFile=new File(root);
        //当文件夹不存在时，则创建一个多层次目录防止path后面是个变量文件夹名
        if (!rootFile.exists()){
            rootFile.mkdirs();
        }
        //步骤2，在test文件夹下面创建1-10，和文件夹同名的文件txt
        for (int i=0;i<10;i++){
            //获取test文件下面的根目录,并创建1-10文件夹
            String dirPath=root+File.separator+(i+1);
            File dirFile=new File(dirPath);
            //还是判断下面是否有同名的文件夹
            if(!dirFile.exists()){
                //当文件夹不存在时，则创建一个
                dirFile.mkdir();
                //创建1-10同名txt文件
                String txtPath=dirPath+File.separator+(i+1)+".txt";
                File txtFile=new File(txtPath);
                //判断txt是否存在不存在则创建
                if (!txtFile.exists()){
                    txtFile.createNewFile();
                 }
                //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txtFile.getAbsoluteFile()));
                //在TXT文件中追加写入操作
                FileWriter fileWriter=new FileWriter(txtFile.getAbsoluteFile());
                fileWriter.write("hello java,我在复习，争取做一个有上进心的人!");
                fileWriter.close();

            }
                    }
    }

}
