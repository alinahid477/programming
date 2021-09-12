package com.problems;

import com.problems.ProCon.PCManager;

import org.junit.jupiter.api.BeforeAll;

//import org.junit.Test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;


public class PCTest extends TestCase{
    
    private static PCManager manager;

    @BeforeAll
    public static void before() {
        manager = new PCManager();
    }

    @Test
    public void testPCManager() {
        manager.doProducer("1");
        manager.doProducer("2");
        manager.doProducer("3");
        manager.doProducer("4");
        
        manager.doConsumer();
        manager.producerSem.release();
        manager.doConsumer();
        manager.doConsumer();
    }

    
}