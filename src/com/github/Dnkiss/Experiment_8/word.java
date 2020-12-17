package com.github.Dnkiss.Experiment_8;

import java.io.*;


public class word {
    public static void main(String[] args) throws FileNotFoundException {
        String path1="D:\\java";
        String name="\\a";
        String end=".mp3";
        String path2;
        String path="D:\\java";
        long l;
        long n=5;//设置分割数目
        File file = new File(path1+name+end);
        File file2;
        l=file.length();
        InputStream in = null;
        PrintStream out = null;
        try {

            in = new FileInputStream(file);
            int tempbyte;
            int i=0;
            for(i=1;i<=n;i++) {
                path2=path+name+"_"+i+end;
                file2=new File(path2);
                if(file2.exists()) {}
                else {
                    file2.createNewFile();
                }
                out=new PrintStream(file2);
                while ((tempbyte =  in.read()) != -1) {

                    out.print((char)tempbyte);
                    System.out.write(tempbyte);
                    if(file2.length()>l/n)break;
                }
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

}
