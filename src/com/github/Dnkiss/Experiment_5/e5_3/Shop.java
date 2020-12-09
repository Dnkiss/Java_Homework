package com.github.Dnkiss.Experiment_5.e5_3;

class Shop implements Runnable
{
    Thread  zhangWorker,wangWorker,boss;
    Shop()
    {
        boss = new Thread(this);  // 创建boss，Shop对象为boss目标对象
        zhangWorker = new Thread(this);  // 创建zhangWorker，Shop对象为zhangWorker 目标对象
        wangWorker = new Thread(this);  // 创建wangWorker，Shop对象为wangWorker目标对象
        zhangWorker.setName("张工");
        wangWorker.setName("王工");
        boss.setName("老板");
    }
    public void run()
    {
        int i=0;
        if(Thread.currentThread()==zhangWorker)
        {
            while(true)
            {
                try{
                    i++;
                    System.out.printf("\n%s已搬运了%d箱苹果\n",zhangWorker.getName(),i);
                    if(i==3)
                        return;
                      zhangWorker.sleep(10000);       // zhangWorker休眠10秒（10000毫秒）
                }
                catch(InterruptedException e)
                {
                    System.out.printf("\n%s让%s继续工作",
                            boss.getName(),zhangWorker.getName());
                }
            }
        }
        else if(Thread.currentThread()==wangWorker)
        {
            while(true)
            {
                try{
                    i++;
                    System.out.printf("\n%s已搬运了%d箱苹果\n",wangWorker.getName(),i);
                    if(i==3)
                        return;
                      wangWorker.sleep(10000);       // wangWorker休眠10秒（10000毫秒）
                }
                catch(InterruptedException e)
                {
                    System.out.printf("\n%s让%s继续工作",
                            boss.getName(),wangWorker.getName());
                }
            }
        }
        else if(Thread.currentThread()==boss)
        {
            while(true)
            {
                    zhangWorker.interrupt();      // 吵醒zhangWorker
                    wangWorker.interrupt();      // 吵醒wangWorker
                if(!(wangWorker.isAlive()||zhangWorker.isAlive()))
                {
                    System.out.printf("%n%s下班",boss.getName());
                    return;
                }
            }
        }
    }
}

