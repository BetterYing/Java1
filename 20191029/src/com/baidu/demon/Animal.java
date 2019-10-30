package com.baidu.demon;

public class Animal {
    protected String name;
    protected int age;
    /*static{
        System.out.println("animal static{}");
    }
    {
        System.out.println("animal instance{}");
    }*/

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("animal(String,int)");
    }

    public void eat(){
        System.out.println(this.name + " animal :: 吃饭！");
    }
}
