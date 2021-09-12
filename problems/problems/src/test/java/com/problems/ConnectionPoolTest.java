package com.problems;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.problems.ConnectionPool.ConnectionFactory;
import com.problems.ConnectionPool.ConnectionsPoolManager;
import com.problems.ConnectionPool.DBConnection;
import com.problems.ConnectionPool.interfaces.Connection;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {

    @Test
    public void testConnectionFactory() {
        ConnectionFactory<DBConnection> factory = new ConnectionFactory<DBConnection>() {
        };
        try {
            Connection c = factory.createConnection(1);
            assertTrue("DBConnection", c.getClass().isAssignableFrom(DBConnection.class));
            Connection b = factory.createConnection(2);
            assertTrue("No dupplicate", c.getGUID() == b.getGUID());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConnectionsPool() {

        final ConnectionsPoolManager pool = ConnectionsPoolManager.getManager();
        List<Connection> gotConnections = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {                    
                    executor.submit(() -> {
                        try {             
                            Thread.sleep(1000);               
                            pool.create(DBConnection.class);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    });
                }
                
            }
        });
        
        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for(int i=0; i<20; i++) {
                    executor.submit(() -> {
                        try {
                            //random.nextInt(1000);
                            Thread.sleep(1000);
                            Connection c = pool.get(DBConnection.class);
                            gotConnections.add(c);
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    });
                }
                
                
            }
        });


        Thread t3 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                for(int i=0; i<300; i++) {
                    executor.submit(() -> {
                        try {
                            Thread.sleep(300);
                            if(!gotConnections.isEmpty()) {
                                pool.close(gotConnections.remove(0));
                            } else {
                                System.out.println("gotConnections is empty");
                            }
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    });
                }
                
                
            }
        });
        

        t1.start();
        t2.start();
        t3.start();
        
        ConnectionsPoolManager pool2 = ConnectionsPoolManager.getManager();
        System.out.println("debug output" + pool2.getId());
        
    }

}