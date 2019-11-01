import test.demon.Animal;
import test.demon.Bird;
import test.demon.Cat;
public class Test {
    public static void main(String[] args) {
        Animal bird2 = new Bird("圆圆");

       // Bird bird = new Bird("圆圆");

//        Animal bird2 = bird;
        ((Bird) bird2).fly();

    }


    public static void main2(String[] args) {
        Animal animal = new Animal("小动物");
        //System.out.println(animal.name);
    }
    public static void main1(String[] args) {
        Cat cat = new Cat("小黑");
        cat.eat("鱼");
        Bird bird = new Bird("圆圆");
        bird.fly();
    }
}
