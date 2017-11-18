package com.prospring4.ch5.security;

public class Userinfo {

    private String userName;
    private String password;

    public Userinfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getUserName(){
        return userName;
    }
}
