package test.demon;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(this.name + " fly " );
    }
}
