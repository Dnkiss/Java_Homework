package com.github.Dnkiss.Homework_5;

public class Process {
    private double arriveTime, serviceTime;
    private int order;
    Process(int arriveTime, int serviceTime,int order){
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
        this.order = order;
    }
    public double getArriveTime(){
        return arriveTime;
    }
    public double getServiceTime(){
        return serviceTime;
    }
    public int getOrder(){
        return order;
    }
}
