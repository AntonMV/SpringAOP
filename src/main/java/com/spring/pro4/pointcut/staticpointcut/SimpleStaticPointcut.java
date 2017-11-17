package com.spring.pro4.pointcut.staticpointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;

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
