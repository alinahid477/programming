package com.interview.atls.EventDriven.Subscribers;

public class CoffeeMachine implements Machine {
    
    @Override
    public void make(int orders) {
        System.out.println("Making "+orders+" coffees");
    }
}