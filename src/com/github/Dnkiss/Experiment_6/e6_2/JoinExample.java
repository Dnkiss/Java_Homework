package com.github.Dnkiss.Experiment_6.e6_2;

class JoinExample
{
    public static void main(String args[ ])
    {
        JoinThread  a=new JoinThread ( );
        a.运货司机.start( );
        a.装运工.start( );
        a.仓库管理员.start( );
    }
}

