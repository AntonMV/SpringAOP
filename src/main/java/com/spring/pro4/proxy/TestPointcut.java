package com.spring.pro4.proxy;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut{
    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass) {
        return ("advised".equals(method.getName()));
    }
}
