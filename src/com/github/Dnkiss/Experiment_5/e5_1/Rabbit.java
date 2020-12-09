package com.github.Dnkiss.Experiment_5.e5_1;

class Rabbit extends Thread
{
    int sleepTime=0,liveLength;
    Rabbit(int sleepTime,String name,int liveLength)
    {
        this.sleepTime=sleepTime;
        this.liveLength=liveLength;
        this.setName(name);   // 设置线程的名字为name
    }
    public void run()
    {
        while(true)
        {
            liveLength--;
            System.out.printf("*");
            try
            {
             Thread.sleep(sleepTime);  // 让线程调用 sleep方法进入中断状态，sleepTime毫秒后
// 线程重新排队，等待CUP资源
            }
            catch(InterruptedException e)
            {
            }
            if(liveLength<=0)
            {
                System.out.printf(getName()+"进入死亡状态\n");
                break;  // 结束run方法的语句
            }
        }
    }
}
