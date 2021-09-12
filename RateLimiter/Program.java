package com.interview.atls.RateLimiter;

import java.util.Map;
import java.util.HashMap;

public class Program {
    
    private Map<String, Object[]> requestMap;

    private final long REQUEST_WINDOW = 5000L;
    private final int MAX_REQUEST_ALLOWED = 5;

    public Program() {
        requestMap = new HashMap<>();
    }

    public boolean isRequestAllowed(RequestObject req) {
        if(requestMap.containsKey(req.getCustomerIP())) {
            Object[] pair = requestMap.get(req.getCustomerIP());
            if(isExpired( ((Long)pair[0]).longValue() )) {
                renew(req.getCustomerIP(), req.getCustomerCredit(), (Integer)pair[1]);
                return true;
            } else if( ((Integer)pair[1]).intValue() > MAX_REQUEST_ALLOWED ) {
                return false;
            } 
            pair[1] = ((Integer)pair[1]) + 1;
            requestMap.put(req.getCustomerIP(), pair);            
        } else {
            renew(req.getCustomerIP(), req.getCustomerCredit(), 0);  
        }
        return true;
    }

    public void renew(String customerIP, int credit, int currentCount) {
        int rollOverCredit = MAX_REQUEST_ALLOWED - currentCount + credit;
        requestMap.put(customerIP, new Object[] {System.currentTimeMillis() + REQUEST_WINDOW, 1-rollOverCredit});
    }

    public boolean isExpired(long expiryTime) {
        long cur = System.currentTimeMillis();
        return cur > expiryTime;
    }

}