package com.github.Dnkiss.Experiment_6.e6_1;

public class SaleExample
{
    public static void main(String args[])
    {
        Cinema cinema=new Cinema();
        cinema.zhao.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.qian.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.sun.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.li.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
        }
        cinema.zhou.start();
    }
}

