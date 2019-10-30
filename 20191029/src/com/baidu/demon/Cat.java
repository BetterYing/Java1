package com.baidu.demon;

public class Cat extends Animal {
    public String sex;
    /*static{
        System.out.println("cat static{}");
    }
    {
        System.out.println("cat instance{}");
    }*/


    public Cat(String name,int age,String sex) {
        super(name,age);
        /*
        * super.name = "bit";
        * super.eat();
        */
        this.sex = sex;
        System.out.println("cat(String,int,String)");
    }

    public void show() {
        System.out.println(this.name + " " + this.age);
    }

    public void eat() {
        System.out.println(this.name + " Cat :: eat()");
    }


}
