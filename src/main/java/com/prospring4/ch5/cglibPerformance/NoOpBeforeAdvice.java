package com.prospring4.ch5.cglibPerformance;

import com.sun.istack.internal.Nullable;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        // операции отсутствуют
    }
}
