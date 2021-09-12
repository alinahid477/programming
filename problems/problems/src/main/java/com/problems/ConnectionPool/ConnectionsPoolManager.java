package com.problems.ConnectionPool;

import java.util.concurrent.Semaphore;

import com.problems.ConnectionPool.interfaces.Connection;

public class ConnectionsPoolManager {
    
    private static ConnectionsPoolManager manager;
    
    public Semaphore sem1;
    public Semaphore sem2;
    ConnectionsPool pool;
    final double id; 

    public static ConnectionsPoolManager getManager() {
        if(manager == null) {
            manager = new ConnectionsPoolManager(); 
        }
        System.out.println(manager.getId());
        return manager;
    }

    private ConnectionsPoolManager() {
        sem1 = new Semaphore(2);
        sem2 = new Semaphore(3);
        pool = new ConnectionsPool();
        id = Math.random();
    }

    public double getId() {
        return this.id;
    }

    public <T extends Connection> void create(final Class<T> connnectionType) throws Exception {
        sem1.acquireUninterruptibly();
        pool.create(connnectionType);
        sem1.release();
    }

    public <T extends Connection> T get(final Class<T> connectionType) throws Exception {
        sem2.acquireUninterruptibly();
        T c = pool.get(connectionType);
        return c;
    }

    public <T extends Connection> void close(T conToClose) throws Exception {
        pool.close(conToClose);
        sem2.release();
    }
}