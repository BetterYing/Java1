public class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " " + age + " " +  " 吃饭！");
    }
    public void sleep() {
        System.out.println(name + " " + age + " " +  " 睡觉！");
    }
}
