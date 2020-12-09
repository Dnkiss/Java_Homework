package com.github.Dnkiss.Experiment_6.e6_1;

class Cinema implements Runnable         // 实现Runnable接口的类
{
    Thread zhao,qian,sun,li,zhou;           // 电影院中买票的线程
    TicketSeller seller;                    // 电影院的售票员
    Cinema()
    {
        zhao=new Thread(this);
        qian=new Thread(this);
        sun=new Thread(this);
        li=new Thread(this);
        zhou=new Thread(this);
        zhao.setName("赵");
        qian.setName("钱");
        sun.setName("孙");
        li.setName("李");
        zhou.setName("周");
        seller=new TicketSeller();
    }
    public void run()
    {
        if(Thread.currentThread()==zhao)
        {
            seller.sellTicket(20,2);
        }
        else if(Thread.currentThread()==qian)
        {
            seller.sellTicket(20,1);
        }
        else if(Thread.currentThread()==sun)
        {
            seller.sellTicket(10,1);
        }
        else if(Thread.currentThread()==li)
        {
            seller.sellTicket(10,2);
        }
        else if(Thread.currentThread()==zhou)
        {
            seller.sellTicket(5,1);
        }
    }
}

