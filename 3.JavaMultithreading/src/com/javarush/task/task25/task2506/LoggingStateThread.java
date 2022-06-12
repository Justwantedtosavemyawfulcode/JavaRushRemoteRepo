package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        State state = thread.getState();
        if (state == State.TERMINATED) {
            System.out.println(state);
            stop();
        }
        System.out.println(state);
        while (state != State.TERMINATED) {
            State currentState = thread.getState();
            if ((currentState != State.TERMINATED) && currentState != state) {
                System.out.println(currentState);
            }
            state = currentState;
        }
        System.out.println(State.TERMINATED);
    }
}
