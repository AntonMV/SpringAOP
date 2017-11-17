package com.spring.pro4.afteradvice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] objects, @Nullable Object target) throws Throwable {
        if ((target instanceof KeyGenerator)
                && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();
            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException(
                        "Кеу Generator generated а weak key. Try again");
                         //Генератор вьщал слабый ключ.Требуется повторны вызов.
            }
        }
    }
}
