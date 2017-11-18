package com.prospring4.ch5.cflowPointcuts;

import com.sun.istack.internal.Nullable;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("Before method: " + method);
    }
}
