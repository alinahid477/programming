package com.problems.ProCon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCQueue {

    private final Lock lock = new ReentrantLock(true);
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    private List<String> q = new ArrayList<>();
    private final int QUEUE_SIZE = 2;
    
    public boolean enque(String val) throws InterruptedException {
        lock.lock();
        try {
            while(q.size() == QUEUE_SIZE) {
                System.out.println("Queue is full waiting");
                isFull.await();
            }
            System.out.println("enqueueing "+val);
            q.add(val);
            isEmpty.signalAll();
            return true;
        } finally {
            lock.unlock();
        }
        
    }

    public String dequeue() throws InterruptedException {
        lock.lock();
        try {    
            while(q.isEmpty()) {
                isEmpty.await();
            }
            String v = q.remove(0);
            isFull.signalAll();
            return v;
        } finally {
            lock.unlock();
        }
    }
}