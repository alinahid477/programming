package com.problems.ConnectionPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.problems.ConnectionPool.interfaces.Connection;

public class ConnectionsPool {
    
    final int POOL_SIZE=3;

    AtomicInteger i= new AtomicInteger(0);
    List<Connection> pool = new LinkedList<>();
    List<Connection> used = new LinkedList<>();

    Lock lock = new ReentrantLock(true);
    Condition createCondition = lock.newCondition();
    Condition getCondition = lock.newCondition();
    
    public <T extends Connection> void create(Class<T> connnectionType) throws Exception {
        lock.lock();
        Thread.sleep(5000);
        while(pool.size() + used.size() == POOL_SIZE) {
            System.out.println("pool is full.");
            createCondition.await();
        }
        if(connnectionType.isAssignableFrom(DBConnection.class)) {
            ConnectionFactory<DBConnection> factory = new ConnectionFactory<DBConnection>(){};
            Connection c = factory.createConnection(i.incrementAndGet());
            pool.add(c);
        }
        getCondition.signalAll();
        lock.unlock();
    }

    public <T extends Connection> T get(Class<T> connectionType) throws Exception {
        lock.lock();
        while(pool.size() == 0) {
            //throw new Exception("no connection left");
            System.out.println("pool is empty.");
            getCondition.await();
        }
        T ret = null;
        for(Connection c : pool) {
            if(c.getClass().isAssignableFrom(connectionType)) {
                used.add(c);
                System.out.println("got connection:" + c.getIDX());
                ret = connectionType.cast(c);
                break;
            }
        }
        pool.remove(ret);
        createCondition.signalAll();
        lock.unlock();
        return ret;
    }

    public <T extends Connection> void close(T conToClose) throws InterruptedException {
        lock.lock();
        Thread.sleep(5000);
        Connection con = null;
        for(Connection c : used) {
            if(c.getGUID() == conToClose.getGUID()) {
                pool.add(c);
                con = c;
                break;
            }
        }
        if(con != null) {
            System.out.println("closing.."+con.getIDX());
            used.remove(con);
            getCondition.signalAll();
        }
        lock.unlock();
    }

    public synchronized int getPoolSize() {
        return pool.size();
    }

}