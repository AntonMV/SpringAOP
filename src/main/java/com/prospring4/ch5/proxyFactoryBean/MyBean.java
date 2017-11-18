package com.prospring4.ch5.proxyFactoryBean;

public class MyBean {
    private MyDependency dep;

    public void execute(){
        dep.foo();
        dep.bar();
    }

    public void setDep(MyDependency dep){
        this.dep = dep;
    }
}
