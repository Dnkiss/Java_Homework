package com.github.Dnkiss.Homework_2;

public class Person implements Runnable {
    public void run()
    {
        synchronized(this) {
            try {
                Thread.sleep(300);
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
            thread.start();
        }
    }
}

