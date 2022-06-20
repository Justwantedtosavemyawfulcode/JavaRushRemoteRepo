package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    static int priority = 0;

    {

    }

    public MyThread() {
        if (priority == MAX_PRIORITY) priority = 0;
        this.setPriority(++priority);
    }

    public MyThread(Runnable target) {
        super(target);
        if (priority == MAX_PRIORITY) priority = 0;
        this.setPriority(++priority);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (group.getMaxPriority() <= priority) {
            this.setPriority(group.getMaxPriority());
            ++priority;
            if (priority == MAX_PRIORITY) priority = 0;
        }
        else this.setPriority(++priority);
    }

    public MyThread(String name) {
        super(name);
        if (priority == MAX_PRIORITY) priority = 0;
        this.setPriority(++priority);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (group.getMaxPriority() <= priority) {
            this.setPriority(group.getMaxPriority());
            ++priority;
            if (priority == MAX_PRIORITY) priority = 0;
        }
        else this.setPriority(++priority);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (priority == MAX_PRIORITY) priority = 0;
        this.setPriority(++priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (group.getMaxPriority() <= priority) {
            this.setPriority(group.getMaxPriority());
            ++priority;
            if (priority == MAX_PRIORITY) priority = 0;
        }
        else this.setPriority(++priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (group.getMaxPriority() <= priority) {
            this.setPriority(group.getMaxPriority());
            ++priority;
            if (priority == MAX_PRIORITY) priority = 0;
        }
        else this.setPriority(++priority);
    }

}
