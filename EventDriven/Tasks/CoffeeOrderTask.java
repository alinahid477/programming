package com.interview.atls.EventDriven.Tasks;

import com.interview.atls.EventDriven.Subscribers.CoffeeMachine;
import com.interview.atls.EventDriven.Subscribers.Machine;

public class CoffeeOrderTask implements PublishTask {
    
    private Machine coffeeMachine = new CoffeeMachine();

    @Override
    public String getStatus() {
        return "DEFAULT";
    }

    @Override
    public void publish(int quantity) {
        System.out.println("placing order "+quantity);
        coffeeMachine.make(quantity);
    }
}