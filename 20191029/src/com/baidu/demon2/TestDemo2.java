package com.baidu.demon2;


class Animal {
    protected String name;
    protected int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("animal(String,int)");
    }
    public void eat(){
        System.out.println(this.name + " animal :: 吃饭！");
    }
}


class Cat extends Animal {
    public String sex;

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

public class TestDemo2 {
    public static void main(String[] args){
        Animal animal = new Animal("doudou",4);
        animal.eat();
    }

}
