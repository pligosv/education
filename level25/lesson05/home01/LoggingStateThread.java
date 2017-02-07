package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread t) {
        this.thread = t;
        setDaemon(true);
    }

    @Override
    public void run() {
        State currentstate = thread.getState();
        System.out.println(currentstate);
        while (true)
        {
            State newstate = thread.getState();
            if (currentstate != newstate)
            {
                System.out.println(newstate);
                currentstate = newstate;
            }
            if (newstate == State.TERMINATED)
            {
                break;
            }
        }
    }
}
