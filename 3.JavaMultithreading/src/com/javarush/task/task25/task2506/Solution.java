package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}

class LoggingStateThread extends Thread {
    Thread t;
    public LoggingStateThread (Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        Thread.State ts = t.getState();
        System.out.println(ts);
        while (!t.getState().equals(State.TERMINATED)) {
            if (!t.getState().equals(ts)) {
                ts = t.getState();
                System.out.println(ts);
            }
        }
        if (!t.getState().equals(ts)) System.out.println(t.getState());
    }
}
