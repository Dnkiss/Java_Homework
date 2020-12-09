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
        DataOutputStream dos = null;
        dos = new DataOutputStream(new FileOutputStream(data));
        DataInputStream ios = null;
        ios = new DataInputStream(new FileInputStream(data));
        for(int i = 0;i < 10; i++)
        {
            int randomNum = R.nextInt(1000) + 1001;
            System.out.println(randomNum);
        }
        dos.close();
        ios.close();
        if (data.isFile() && data.exists()){
            data.delete();
            System.out.println("文件删除");
        }
        else {
            System.out.println("文件不存在");
        }
    }
}
