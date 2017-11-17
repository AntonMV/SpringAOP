package com.spring.pro4.beforeadvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();

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
