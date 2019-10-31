
class Money implements Cloneable{
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public String name;
    public int age;

    Money m;//组合


    public Person() {

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.m = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        this.m = (Money)p.m.clone();
        return p;
    }
}

public class Test6 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("caocao",18);
        Person person1 = (Person)person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
        person1.m.money = 45;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);

    }



    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.name = "liubei";
        Person person1 = (Person) person.clone();
        person1.name = "guanyu";
        System.out.println(person.name);
        System.out.println(person1.name);

    }
}
