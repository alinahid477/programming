package com.interview.atls.EventDriven.Publishers;

import com.interview.atls.EventDriven.Tasks.TaskFacotry;

public class OrderService {
    
    public void createNewOrder(String orderName) {
        TaskFacotry.getInstance().getTask(orderName).publish(10);
    }
}