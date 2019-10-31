/**
 * 接口 interface：为了多继承
 * 1.接口中的方法 一定不能有具体的实现  因为都是抽象的方法
 * 2.void draw() 默认是public abstract void draw();
 * 3.int a = 10，默认是public static final int a = 10;
 * 4.普通的类不能继承接口，但是可以实现
 * 5.接口是不可以实例化的，但是可以发生向上转型
 * 6.一个类可以实现多个接口 calss Dog extends Animal implements IRunning,ISwimming
 * 7.抽象类可以实现接口
 * 8.接口之间是不能发生实现的，但是可以继承,可以继承多个
 */


interface IShape {
    void draw();
}

class Cycle2 implements IShape{

    @Override
    public void draw() {
        System.out.println("hauyuan");
    }
}
class Rect2 implements IShape{
    @Override
    public void draw() {
        System.out.println("huanjuxing");
    }
}

public class Test4 {

    public static void main(String[] args) {
        IShape shape = new Cycle2();
        IShape shape1 = new Rect2();

    }
}
