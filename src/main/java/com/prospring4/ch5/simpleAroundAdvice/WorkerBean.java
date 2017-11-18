package com.prospring4.ch5.simpleAroundAdvice;

public class WorkerBean {
    public void doSomeWork(int noOfTimes){
        for(int х = 0; х < noOfTimes; х++) {
            work();
        }
    }

    private void work(){
        System. out.print("");
    }
}
