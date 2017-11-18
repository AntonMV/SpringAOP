package com.prospring4.ch5.staticPointcut;

import com.sun.istack.internal.Nullable;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, @Nullable Class<?> aClass) {
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> cls){
                return (cls == BeanOne.class);
            }
        };
    }
}
