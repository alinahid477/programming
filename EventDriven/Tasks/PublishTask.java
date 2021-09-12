package com.interview.atls.EventDriven.Tasks;

public interface PublishTask {
    
    String getStatus();

    void publish(int quantity);
}