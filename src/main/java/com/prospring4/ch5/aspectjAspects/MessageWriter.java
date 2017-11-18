package com.prospring4.ch5.aspectjAspects;

public class MessageWriter {
    public void writeMessage(){
        System.out.println("foobar()");
    }

    public void foo() {
        System.out.println("foo()");
    }
}