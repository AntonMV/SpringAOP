package com.prospring4.ch5.aspectjAspects;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(new String[] {"classpath:aspectjAspects.xml"});
            ctx.refresh();
            MessageWriter writer = new MessageWriter();
            writer.writeMessage();
            writer.foo();
    }
}
