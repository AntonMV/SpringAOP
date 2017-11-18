package com.prospring4.ch5.security;

import com.sun.istack.internal.Nullable;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private com.prospring4.ch5.security.SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new com.prospring4.ch5.security.SecurityManager();

    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        Userinfo user = securityManager.getLoggedOnUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException(
                    "You must login before attempting to invoke the method: " + method.getName());
        }else if ( "chris".equals(user.getUserName()) ){
            System.out.println( "Logged in user is chris - OKAY!");
        }else{
            System.out.println("Logged in user is " + user.getUserName()
                    + " NOT GOOD : (");
            throw new SecurityException("User " + user.getUserName()
                    + " is not allowed access to method " + method.getName()) ;
        }
    }
}
