package com.baidu.demon;


class Address{
    public String dormitory;
    public int floor;

    public Address(String dormitory, int floor) {
        this.dormitory = dormitory;
        this.floor = floor;
    }
}

class Student{
    public String name;
    public int age;
    public Address address;

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", address.dormitory = " + address.dormitory +
                ", address.floor = " + address.floor +
                '}';
    }
}

public class TestDemo {

    public static void main(String[] args) {
//        Animal animal = new Cat("doudou",4,"men");
//        animal.eat();
        Animal animal = new Animal("doudou",4);
        animal.eat();
    }




    public static void main3(String[] args){
        Animal animal = new Cat("dou",2,"female");
        animal.eat();
        Cat cat = new Cat("douer",2,"female");
        func(cat);
        Animal animal2 = func2();
        animal2.eat();
    }

    public static void func(Animal animal) {
        animal.eat();
    }
    public static Animal func2() {
        Cat cat = new Cat("xiaodouer",2,"female");
        return cat;
    }


    public static void main2(String[] args){
        Address address = new Address("6",5);
        Student student = new Student("caocao",78,address);
        System.out.println(student);
    }

    public static void main1(String[] args){
        Cat cat = new Cat("yuanyuan",3,"men");
//        cat.eat();
        Animal animal = new Animal("xiaoyuan",4);
        System.out.println(animal.name);

    }
}
