package com.prospring4.ch5.dynamicPointcut;

public class SampleBean {

    public void foo (int х) {
        System.out.println("Invoked foo() with: " + х);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }
}
