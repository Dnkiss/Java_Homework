package com.github.Dnkiss.Experiment_7;

import java.io.*;
import java.util.*;

public class Project {
    public static void main(String[] args) throws IOException {
        Scanner temp = new Scanner(System.in);
        //学生信息储存在集合类中
        ArrayList<Student> array = new ArrayList<Student>();
        //启动应用便开始从硬盘加载数据
        loadData(array);
        while (true) {
            System.out.println("----欢迎来到学生管理系统，请选择操作----");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生信息");
            System.out.println("3 修改学生信息");
            System.out.println("4 删除学生信息");
            System.out.println("5 退出系统");
            //输入选项
            String choice = temp.nextLine();
            //判断
            switch (choice) {
                case "1":
                    query(array);
                    break;
                case "2":
                    add(array);
                    storeData(array);//修改数据之后立即更新硬盘文件
                    break;
                case "3":
                    modify(array);
                    storeData(array);//修改数据之后立即更新硬盘文件
                    break;
                case "4":
                    delete(array);
                    storeData(array);//修改数据之后立即更新硬盘文件
                    break;
                case "5":
                    System.out.println("感谢您的使用，再见！");
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新选择！");
            }
        }
    }
    private static void loadData(ArrayList<Student> array) throws IOException{
        //初次打开应用会创建文件
        File file= new File("infm.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("初次启动初始化完成！");
        }
        //从文件中读取数据进集合
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null){
            String [] str = line.split("&");
            Student s = new Student();
            s.setNum(str[0]);
            s.setName(str[1]);
            s.setAge(str[2]);
            s.setCity(str[3]);
            array.add(s);
        }
        br.close();
    }
    //储存数据到文件中
    private static void storeData(ArrayList<Student> array) throws IOException{
        File file= new File("infm.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //直接将数据全部存储到文件中，不用追加方法，也方便增删查改
        //如何信息量比较大就不适应
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //将数据存储进文件
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            bw.write(s.getNum(),0,s.getNum().length()-1);//导出学号
            bw.write('&');//间隔不同数据
            bw.write(s.getName(),0,s.getName().length()-1);//导出姓名
            bw.write('&');//间隔不同数据
            bw.write(s.getAge(),0,s.getAge().length()-1);//导出年龄
            bw.write('&');//间隔不同数据
            bw.write(s.getCity(),0,s.getCity().length()-1);//导出所在地
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    //查询学生信息方法
    private static void query(ArrayList<Student> array){

        if(array.size() == 0){
            System.out.println("暂时未存储任何学生信息，请重新选择。");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t城市");
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getCity());
        }
    }
    //添加学生信息方法
    private static void add(ArrayList<Student> array){
        Scanner temp = new Scanner(System.in);
        String num;
        while(true){
            System.out.println("请输入新同学学号：");
            num = temp.nextLine();
            //判断是否重复学号
            boolean flag = false;//默认未重复
            for(int i=0;i<array.size();i++){
                Student s = array.get(i);
                if(s.getNum().equals(num)){
                    System.out.println("该学号已经存在，请重新输入！");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println("请输入新同学姓名：");
        String name = temp.nextLine();
        System.out.println("请输入新同学年龄：");
        String age = temp.nextLine();
        System.out.println("请输入新同学所在城市：");
        String city = temp.nextLine();
        Student s = new Student();
        s.setNum(num);
        s.setName(name);
        s.setAge(age);
        s.setCity(city);
        array.add(s);
        System.out.println("添加学生信息成功！");
    }
    //修改学生信息方法
    private static void modify(ArrayList<Student> array){
        Scanner temp = new Scanner(System.in);
        int index = -1;//查找标志
        System.out.println("请输入需要修正的学生学号：");
        String num = temp.nextLine();
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getNum().equals(num)){
                index = i;
                break;
            }
        }
        if(index == -1){//未找到学生直接返回
            System.out.println("未找到相应学号所对应学生！");
            return;
        }else{
            System.out.println("请输入需要更改的姓名：");
            String name = temp.nextLine();
            System.out.println("请输入需要更改的年龄：");
            String age = temp.nextLine();
            System.out.println("请输入需要更改的所在城市：");
            String city = temp.nextLine();
            Student s = array.get(index);
            s.setName(name);
            s.setAge(age);
            s.setCity(city);
            System.out.println("学生信息更新成功！");
        }
    }
    //删除学生信息方法
    private static void delete(ArrayList<Student> array){
        Scanner temp = new Scanner(System.in);
        System.out.println("请输入需要删除的学生学号：");
        String num = temp.nextLine();
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getNum().equals(num)){
                System.out.println("请确认删除信息(Y/N)：");
                System.out.println("学号\t\t姓名\t年龄\t城市");
                System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getCity());
                String confirm = temp.nextLine();
                //判断确认删除
                if(confirm.equals("y") || confirm.equals("Y")){
                    if(array.remove(s)){
                        System.out.println("删除成功！");
                        return;
                    }
                }else{
                    System.out.println("已取消删除！");
                    return;
                }
            }
        }
        System.out.println("未找到所对应学生学号，请确认学号信息是否有误!");
    }

}
