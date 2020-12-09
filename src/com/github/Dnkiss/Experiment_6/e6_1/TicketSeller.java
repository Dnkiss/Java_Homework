package com.github.Dnkiss.Experiment_6.e6_1;

class TicketSeller            // 负责卖票的类
{
    int fiveNumber=1,tenNumber=0,twentyNumber=0;
    public synchronized void  sellTicket(int receiveMoney,int buyNumber)
    {
        if(receiveMoney==5)
        {
            fiveNumber=fiveNumber+1;
            System.out.printf("\n%s给我5元钱，这是您的1张入场卷",
                    Thread.currentThread().getName());
        }
        else if(receiveMoney==10&&buyNumber==2)
        {
            tenNumber=tenNumber+1;
            System.out.printf("\n%s给我10元钱，这是您的2张入场卷",
                    Thread.currentThread().getName());
        }
        else if(receiveMoney==10&&buyNumber==1)
        {
            while(fiveNumber < 1)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等",Thread.currentThread().getName());
                    wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待\n",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            fiveNumber=fiveNumber-1;
            tenNumber=tenNumber+1;
            System.out.printf("\n%s给我10元钱，找您5元，这是您的1张入场卷",
                    Thread.currentThread().getName());
        }
        else if(receiveMoney==20&&buyNumber==1)
        {
            while(fiveNumber < 1|| tenNumber < 1)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等",Thread.currentThread().getName());
                    wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            fiveNumber=fiveNumber-1;
            tenNumber=tenNumber-1;
            twentyNumber=twentyNumber+1;
            System.out.printf("\n%s给20元钱，找您一张5元和一张10元，这是您的1张入场卷",
                    Thread.currentThread().getName());
        }
        else if(receiveMoney==20&&buyNumber==2)
        {
            while(tenNumber<1)   // 给出线程需等待的条件
            {
                try {
                    System.out.printf("\n%30s靠边等\n",Thread.currentThread().getName());
                    wait();   // 线程进入等待状态
                    System.out.printf("\n%30s结束等待",Thread.currentThread().getName());
                }
                catch(InterruptedException e)
                {
                }
            }
            tenNumber=tenNumber-1;
            twentyNumber=twentyNumber+1;
            System.out.printf("\n%s给20元钱，找您一张10元，这是您的2张入场卷",
                    Thread.currentThread().getName());
        }
     notify();   // 通知等待的线程结束等待
    }
}

