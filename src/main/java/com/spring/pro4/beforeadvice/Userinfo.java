package com.spring.pro4.beforeadvice;

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
