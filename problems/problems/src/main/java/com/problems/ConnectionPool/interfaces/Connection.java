package com.problems.ConnectionPool.interfaces;

public interface Connection {
    void connect();
    java.util.UUID getGUID();
    int getIDX();
}