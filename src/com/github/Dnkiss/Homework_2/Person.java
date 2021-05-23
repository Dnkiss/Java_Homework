package com.github.Dnkiss.Homework_2;

import java.util.Random;

public class Person implements Runnable {
    public void run()
    {
        synchronized(this) {
            //当前一个线程未结束时，之后的线程将阻塞
            try {
                Random i = new Random();
                //生成随机数
                int r = i.nextInt(128) % (128 - 64 + 1) + 64;
                //随机数范围在64-128之间
                System.out.println((long)r);
                Thread.sleep(r);
                //线程停止r ms
                System.out.println(Thread.currentThread().getName() + "--->过完独木桥");
            }
            catch (InterruptedException i) {
                i.printStackTrace();
            }
        }
    }
    public void thread()
    {
        Person p = new Person();
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(p);
            //创建新线程,以p为模板
            thread.start();
        }
    }
}

