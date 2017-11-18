package com.prospring4.ch5.aspectjAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    @Autowired
    private MyDependency myDependency;

    public void execute() {
        myDependency.foo(100);
        myDependency.foo(101);
        myDependency.bar();
    }
        public void setDep(MyDependency myDependency){
            this.myDependency = myDependency;
        }
}
