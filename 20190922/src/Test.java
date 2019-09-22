class TestDemo{
    public int a;
    public static int count;
}

public class Test {
    public static void main(String[] args) {
//        Person person = new Person();
////        System.out.println(person.name);
////        System.out.println(person.age);
////        System.out.println(person.sex);
//        person.show();
////        person.eat();
//    }
        TestDemo t1 = new TestDemo();
        t1.a++;
        TestDemo.count++;
        System.out.println(t1.a);
        System.out.println(TestDemo.count);
        System.out.println("==============");
        TestDemo t2 = new TestDemo();
        t2.a++;
        TestDemo.count++;
        System.out.println(t2.a);
        System.out.println(TestDemo.count);
    }
}
