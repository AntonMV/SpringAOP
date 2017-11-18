package com.prospring4.ch5.aopNamespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:aopNamespace.xml");
        ctx.refresh();
        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
