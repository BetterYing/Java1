package test.demon;
public class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + " eat " + food );
    }
}
