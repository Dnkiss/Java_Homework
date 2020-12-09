package com.github.Dnkiss.Experiment_6.e6_2;

class JoinThread  implements Runnable
{
    Thread 运货司机,装运工,仓库管理员;
    String step[ ]={"打开车锁","把握方向盘","挂挡","踩油门","开车"};
    JoinThread()
    {
        运货司机=new Thread(this);
        装运工=new Thread(this);
        仓库管理员=new Thread(this);
        运货司机.setName("运货司机");
        装运工.setName("装运工");
        仓库管理员.setName("仓库管理员");
    }
    public void run()
    {
        if(Thread.currentThread()==运货司机)
        {
            System.out.printf("\n%s等%s", 运货司机.getName(),装运工.getName());
            try{
                  装运工.join();    // 占有CUP资源期间联合线程：装运工
            }
            catch(InterruptedException e)
            {
            }
            for(int i=0;i<step.length;i++)
            {
                System.out.printf("\n%s%s", 运货司机.getName(),step[i]);
                try
                {
                    运货司机.sleep(500);
                }
                catch(InterruptedException ee)
                {
                }
            }

        }
        else if(Thread.currentThread()==装运工)
        {
            System.out.printf("\n%s等%s",装运工.getName(),仓库管理员.getName());
            try{
                  仓库管理员.join();    // 占有CUP资源期间联合线程：仓库管理员
            }
            catch(InterruptedException e)
            {
            }
            for(int i=1;i<=10;i++)
            {
                System.out.printf("\n%s搬运第%d箱货物到货车", 装运工.getName(), i);
                try
                {
                    装运工.sleep(1500);
                }
                catch(InterruptedException ee)
                {
                }
            }
        }
        else if(Thread.currentThread()==仓库管理员)
        {
            for(int i=1;i<=5;i++)
            {
                System.out.printf("\n%s打开第%d道门", 仓库管理员.getName( ), i) ;
                try
                {
                    仓库管理员.sleep(1000);
                }
                catch(InterruptedException e)
                {
                }
            }
        }
    }
}

