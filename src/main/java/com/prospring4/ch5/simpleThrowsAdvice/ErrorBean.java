package com.prospring4.ch5.simpleThrowsAdvice;

public class ErrorBean {
    public void errorProneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException{
        throw new IllegalArgumentException("Bar");
    }

}
