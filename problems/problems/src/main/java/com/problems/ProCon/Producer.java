package com.problems.ProCon;

import java.util.concurrent.Semaphore;

public class Producer {
    
    public void produce(String val, PCQueue q, Semaphore sem) throws InterruptedException {
        sem.acquireUninterruptibly();
        q.enque(val);
        //sem.release();
    }
}