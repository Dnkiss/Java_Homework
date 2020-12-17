package com.github.Dnkiss.Experiment_8;

import java.io.*;

public class Project {
    public static  void  main(String[] args) throws IOException {
        String FileOut="D:\\java";
        BufferedWriter bw=new BufferedWriter(new FileWriter(FileOut));
        File[] list = new File("D:\\java").listFiles();
        int fileCount = 0;
        int folderConut= 0;
        for(File file : list)
        {
            if(file.isFile())
            {
                fileCount++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null) {
                    bw.write(line);
                    bw.newLine();
                }
                br.close();
            }else {
                folderConut++;
            }
        }
        bw.close();
    }

}
