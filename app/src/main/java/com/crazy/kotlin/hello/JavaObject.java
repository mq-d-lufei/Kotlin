package com.crazy.kotlin.hello;

import com.crazy.learn.Father;

public class JavaObject {

    String java = "Java String ...";

    public void printJavaInfo() {
        System.out.println("java = " + java);
    }

    public static void main(String[] args) {

        Father father = new Father();

        father.doSomething();
    }
}
