/*
* 1.抽象类是包含抽象方法的类
* 2.抽象类可以包含抽象方法，也可以包含非抽象方法
* 3.抽象类不可以被实例化，不能new
* 4.一个普通的类，如果继承了抽象类，一定要重写抽象类的抽象方法
* 5.抽象类可以继承抽象类 这样一来 就不需要重写抽象方法
* 6.如果一个普通类C 继承了上述的抽象类A 如果上述的抽象类A并没有重写抽象类B的抽象方法，
*   那么当前的普通类C一定要重写
* 7.抽象类 一定不能是private，抽象类不能是final所修饰
* 8.抽象类发生向上的转型
* */



abstract class Shape1{
    public abstract void draw();
}
class Cycle1 extends Shape1 {
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
class Rect1 extends Shape1{
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}


public class Test3 {
    public static void main(String[] args) {

    }
}
