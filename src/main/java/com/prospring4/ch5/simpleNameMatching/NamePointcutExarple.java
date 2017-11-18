package com.prospring4.ch5.simpleNameMatching;

import com.prospring4.ch5.staticPointcut.SimpleAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutExarple {
    public static void main(String [] args) {
        NameBean target = new NameBean();
        //NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        //pc.addMethodName("foo");
        //pc.addMethodName("bar");
        //Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        NameMatchMethodPointcutAdvisor advisor = new
                NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.addMethodName("foo");
        advisor.addMethodName("bar");
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        NameBean proxy = (NameBean) pf.getProxy();
        proxy.foo();
        proxy.foo(999);
        proxy.bar();
        proxy.yup();
    }
}
