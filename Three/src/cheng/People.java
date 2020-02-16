package cheng;

public class People {
    {
        System.out.println("我是父类普通代码块");
    }
    static {
        System.out.println("我是父类静态代码块");
    }
    public People() {
        System.out.println("我是父类构造代码块");
    }
}
