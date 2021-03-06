package com.prospring4.ch5.security;

public class SecurityManager {

    private static ThreadLocal<Userinfo> threadLocal = new ThreadLocal<Userinfo>();

    public void login(String userName, String password){
        threadLocal.set(new Userinfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public Userinfo getLoggedOnUser(){
        return threadLocal.get();
    }
}
