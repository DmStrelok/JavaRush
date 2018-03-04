package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priority = 0;

    private void setmyPriority() {
        priority = 1 + priority % 10;
        setPriority(priority > getThreadGroup().getMaxPriority() ? getThreadGroup().getMaxPriority() : priority);
    }
    public MyThread() {
        super();
        setmyPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setmyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setmyPriority();
    }

    public MyThread(String name) {
        super(name);
        setmyPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setmyPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setmyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setmyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setmyPriority();
    }
}
