package com.github.Dnkiss.Experiment_5.e5_3;

class ShopExample
{
    public static void main(String args[])
    {
        Shop shop=new Shop();
        shop.zhangWorker.start();
        shop.wangWorker.start();
        shop.boss.start();
    }
}


