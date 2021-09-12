package com.problems.ConnectionPool;

import com.problems.ConnectionPool.interfaces.Connection;

public class DBConnection implements Connection {
    public String url;
    public String username;
    public String password;
    public String dbname;
    
    private final java.util.UUID guid;
    private final int idx;
    public DBConnection(int idx) {
        this.guid = java.util.UUID.randomUUID();
        this.idx = idx;
    }

    @Override
    public void connect() {
        System.out.println("Database Connected "+this.idx);
    }

    @Override
    public java.util.UUID getGUID() {
        return this.guid;
    }

    @Override
    public int getIDX() {
        return this.idx;
    }
}