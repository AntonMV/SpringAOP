package com.prospring4.ch5.cglibPerformance;

import com.sun.istack.internal.Nullable;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut{
    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass) {
        return ("advised".equals(method.getName()));
    }
}
