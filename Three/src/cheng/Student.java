package cheng;

public class Student extends People {
    {
        System.out.println("我是子类的普通代码块");
    }
    static {
        System.out.println("我是子类的静态代码块");
    }
    public Student () {
        System.out.println("我是子类的静态代码块");
    }
}
