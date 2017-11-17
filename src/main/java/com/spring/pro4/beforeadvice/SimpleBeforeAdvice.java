package com.spring.pro4.beforeadvice;

import com.spring.pro4.MessageWriter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String [] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}