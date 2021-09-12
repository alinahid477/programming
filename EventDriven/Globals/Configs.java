package com.interview.atls.EventDriven.Globals;

public class Configs {
    
    private String username;
    private String token;

    private Configs(String usernameArg, String tokenArg) {
        this.username = usernameArg;
        this.token = tokenArg;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
    
}