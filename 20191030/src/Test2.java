import java.util.concurrent.Callable;

class Animal{
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("Animal::eat");
    }
}

class Cat extends Animal {
    public String sex;

    public Cat(String name, int age,String sex) {
        super(name, age);
        this.sex = sex;
    }
    public void eat() {
        System.out.println("Cat :: eat");
    }

    public void run() {
        System.out.println("Cat :: run");
    }
}

class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }
    public void fly() {
        System.out.println("Bird :: fly");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Animal animal = new Bird("麻雀",19);
        //判断向下转型是不是animal的实例，此处bird为animal实例
        //向下转型一定要发生向上转型
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.run();
        }
    }
    public static void main2(String[] args) {
        //类型转换异常java.lang.ClassCastException
        Animal animal = new Bird("麻雀",19);
        Cat cat = (Cat) animal;
        cat.run();
    }

    public static void main1(String[] args) {
        //向下转型
        Animal animal = new Cat("miaomiao",2,"women");
        //向上转型
        Cat cat = (Cat) animal;
        cat.run();
    }

}
