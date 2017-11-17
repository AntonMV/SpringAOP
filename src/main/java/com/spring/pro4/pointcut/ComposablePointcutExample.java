package com.spring.pro4.pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class ComposablePointcutExample {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE,
                new GetterMethodМatcher());
        // Тест l
        System.out.println("Test l");
        SampleBean proxy = getProxy(pc, target);
        testinvoke(proxy);
        // Тест 2
        System.out.println("Test 2");
        pc.union(new SetterMethodМatcher());
        proxy = getProxy(pc, target);
        testinvoke(proxy);
        // Тест 3
        System.out.println("Test 3");
        pc.intersection(new GetAgeMethodМatcher());
        proxy = getProxy(pc, target);
        testinvoke(proxy);
    }

    private static SampleBean getProxy(ComposablePointcut pc,
                                       SampleBean target) {
        Advisor advisor = new DefaultPointcutAdvisor(pc,
                new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        return (SampleBean) pf.getProxy();
    }

    private static void testinvoke(SampleBean proxy){
        proxy.getAge();
        proxy.getName();
        proxy.setName("Chris Schaefer");
    }

    private static class GetterMethodМatcher extends StaticMethodMatcher{
        @Override
        public boolean matches(Method method, Class<?> cls){
            return (method.getName() .startsWith("get"));
        }
    }

    private static class GetAgeMethodМatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> cls) {
            return "getAge".equals(method.getName());

        }
    }

    private static class SetterMethodМatcher extends StaticMethodMatcher{
        @Override
        public boolean matches(Method method, Class<?> cls){
            return (method.getName().startsWith("set"));
        }
    }
}
