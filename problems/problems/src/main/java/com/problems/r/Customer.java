package com.problems.r;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Customer {
    
    final long bucketSize;
    AtomicLong expTime;
    AtomicInteger requestCount;
    final int maxRequest; 
    String customerID;

    public Customer(String customerIDArg, long bucketSizeArg, int maxRequestArg) {
        this.bucketSize = bucketSizeArg;
        this.expTime.set(System.currentTimeMillis()+bucketSizeArg);
        this.maxRequest = maxRequestArg;
        this.requestCount.set(1);
        this.customerID = customerIDArg;
    }

    public boolean isRequestAllowed() {
        
        long currMillis = System.currentTimeMillis();
        if(expTime.get() > currMillis) {
            if(requestCount.incrementAndGet() > maxRequest) {
                return false;
            }
            return true;
        }
        this.doReset();
        return true;
    }

    public void doReset() {
        long currMillis = System.currentTimeMillis();
        this.expTime.set(currMillis+bucketSize);
        this.requestCount.set(1);
    }

    @Override
    public boolean equals(Object o) {
        return customerID.equalsIgnoreCase(((Customer) o).customerID);
    }

}