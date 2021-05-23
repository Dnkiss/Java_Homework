package com.github.Dnkiss.Homework_5;

import java.util.*;

public class Manager {
    public static Queue<Process> p = new LinkedList<>();
    public static int num = 5;
    public static void main(String[] args) {
        for(int i = 0; i < num; i++) {
            int at = i * 2;
            int st = new Random().nextInt(6) + 1;
            p.add(new Process(at, st, i+1));
            System.out.println("第 " + (i+1) + " 个进程到达时间为 " + at + " ,要求服务时间为" + st);
        }

        int i = 0;
        double completeTime = 0;
        List<Process> waitP = new ArrayList<>();
        Process nextP = null;
        while(true){
            if(p.peek() != null){
                if(p.peek().getArriveTime() <= i){
                    waitP.add(p.poll());
                }
            }
            if(i >= completeTime){
                if(waitP.size()>0) {
                    nextP = waitP.get(0);
                    int ft = -1;
                    for(int t = 0;t < waitP.size();t++) {
                        Process process = waitP.get(t);
                        if ((process.getArriveTime() - i + process.getServiceTime()) / process.getServiceTime() <
                                (nextP.getArriveTime() - i + nextP.getServiceTime()) / nextP.getServiceTime()) {
                            nextP = process;
                            ft = t;
                        }
                    }
                    waitP.remove(nextP);
                }
                System.out.println(i);
                System.out.println("第 "+nextP.getOrder()+" 个进程执行");
                completeTime = nextP.getServiceTime()+i;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if(waitP.size()==0 && p.size() == 0) break;
        }
    }
}
