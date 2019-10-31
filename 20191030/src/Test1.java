class Shape {
    public void draw() {

    }
}
class Cycle extends Shape {

    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
public class Test1 {
    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape = new Cycle();
        Shape shape1 = new Rect();
    }

}
