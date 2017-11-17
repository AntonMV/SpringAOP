package com.spring.pro4.pointcut.annotation;

public class SampleAnnotationBean {
    @AdviceRequired
    public void foo(int х) {
        System.out.println("Invoked foo() with: " + х);
    }
    public void bar() {
        System.out.println("Invoked bar()");
    }
}
