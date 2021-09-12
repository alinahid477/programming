package com.problems.ProCon;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class PCManager {
    public Semaphore producerSem;
    private Semaphore consumerSem;

    ThreadPoolExecutor executor;
    PCQueue queue;

    public PCManager() throws IllegalArgumentException {
        producerSem = new Semaphore(3, true);
        consumerSem = new Semaphore(10, true);
        queue = new PCQueue();

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    }

    public void doProducer(String messages) {
        System.out.println("do "+messages);
        executor.execute(
            () -> {
                try {
                    (new Producer()).produce(messages, queue, producerSem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        );
    }

    public void doConsumer() {
        
        executor.execute(
            () -> {
                try {
                    (new Consumer()).consume(queue, consumerSem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        );
    }

}