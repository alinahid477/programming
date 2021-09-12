package com.problems.ConnectionPool;

import com.problems.ConnectionPool.interfaces.Connection;

public class ConnectionFactory<T extends Connection> {

    private T con;

    public T createConnection(int idx) throws Exception {
        return newConnection("DB URL", "UB USER", "DB PASS", "Mongo", idx);
    }

    private T newConnection(String url, String username, String password, String dbname, int idx) throws Exception {
        if(con == null) {
            con = this.getGenericTypeClass().getConstructor(Integer.TYPE).newInstance(idx);
            con.connect();
        }
        
        return con;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericTypeClass() {
        try {
            String className = ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
    } 
}