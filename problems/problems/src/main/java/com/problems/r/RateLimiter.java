package com.problems.r;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {
    
    ConcurrentMap<String,Customer> requests = new ConcurrentHashMap<>();
    private ReentrantLock lock = new ReentrantLock(true);

    public boolean doRequest(RequestObject request) {
        if(requests.containsKey(request.customerID)) {
            Customer c = requests.get(request.customerID);
            return c.isRequestAllowed();
        } 
        lock.lock();
        try{
            Customer c = new Customer(request.customerID, (long)request.maxBucketSize, request.maxAllowedRequest);
            requests.put(request.customerID, c);
            return true;
        } finally {
            lock.unlock();
        }
            
        
        
    }
}