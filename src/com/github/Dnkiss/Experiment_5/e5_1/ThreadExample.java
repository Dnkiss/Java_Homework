package com.github.Dnkiss.Experiment_5.e5_1;

public class ThreadExample
{
    public static void main(String args[ ])
    {
        Rabbit  rabit;
        rabit=new Rabbit(20,"rabbit",100);     // 新建线程rabit
        Tortoise tortoise;
        tortoise=new Tortoise(5,"tortoise",100);  // 新建线程tortoise
        rabit.start();         // 启动线程tortoise
        tortoise.start();       // 启动线程rabit
    }
}

