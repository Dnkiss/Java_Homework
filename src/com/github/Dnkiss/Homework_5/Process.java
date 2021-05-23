package com.github.Dnkiss.Homework_5;

public class Process {
    private int arriveTime, serviceTime, order;
    Process(int arriveTime, int serviceTime,int order){
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
        this.order = order;
    }
    public int getArriveTime(){
        return arriveTime;
    }
    public int getServiceTime(){
        return serviceTime;
    }
    public int getOrder(){
        return order;
    }
}
