package com.baidu.demon3;

class Shape{
    public void draw() {
        System.out.println("Shape :: draw()");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("yuan");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("juxing");
    }
}

public class TestDemo1 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args){
        Shape shape = new Cycle();
        Shape shape1 = new Rect();
//        shape.draw();
//        shape1.draw();
        drawMap(shape);
        drawMap(shape1);
    }
}
