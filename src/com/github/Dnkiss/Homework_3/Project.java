package com.github.Dnkiss.Homework_3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
@SuppressWarnings("unused")
public class Project
{
    private static final int count = 100;
    public static void main(String[] args) throws Exception
    {
        Random R = new Random();
        File data = new File("d:/data.dat");
        System.out.println("创建文件");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(data));
        //创建写入对象 dos，打开文件data（写入从程序写入文件中）
        DataInputStream dis = new DataInputStream(new FileInputStream(data));
        //创建读取对象dis
            for(int i = 0;i < 10; i++)
        {
            int randomNum = R.nextInt(1000) + 1001;
            //随机数范围在1000到1000+1001-1之间
            System.out.println(randomNum);
            dos.write(randomNum);
            //用dos中的一个方法write，往文档中写入数据randomNum
        }
        dos.close();
        dis.close();
        //关闭文件
        if (data.isFile() && data.exists()){
            //isfile判断文件是否为文件形式，多用于Linux系统
            //exists判断路径是否存在
            data.delete();
            //删除文件
            System.out.println("文件删除");
        }
        else {
            System.out.println("文件不存在");
        }
    }
}
