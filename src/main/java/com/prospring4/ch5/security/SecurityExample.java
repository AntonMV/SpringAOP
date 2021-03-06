package com.prospring4.ch5.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String [] args) {
        SecurityManager mgr = new SecurityManager();
        SecureBean bean = getSecureBean();
        mgr.login("chris", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invaliduser", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ех) {
            System.out.println("Exception Caught: " + ех.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
