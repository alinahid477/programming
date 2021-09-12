package com.interview.atls.RateLimiter;

public class RequestObject {
    
    private static RequestObject req;
    
    private String customerIP;

    private int customerCredit;



    private RequestObject(String ip, int credit) {
        this.customerIP = ip;
        this.customerCredit = credit;
    }
    
    public static RequestObject getInstance(String ip, int credit) {
        if(req == null) {
            req = new RequestObject(ip,credit);
        }
        req.customerCredit = credit;
        req.customerIP = ip;
        return req;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public int getCustomerCredit() {
        return customerCredit;
    }
    
    
}