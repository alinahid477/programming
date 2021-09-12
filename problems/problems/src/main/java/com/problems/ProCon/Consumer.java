package com.problems.ProCon;

import java.util.concurrent.Semaphore;

public class Consumer {
    public void consume(PCQueue q, Semaphore sem) throws InterruptedException {
        sem.acquireUninterruptibly();
        String val = q.dequeue();
        System.out.println("consumed messages: "+val);
        //sem.release();
    }
}