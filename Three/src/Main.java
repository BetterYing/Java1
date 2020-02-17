import cheng.Student;
import tai.A;
import tai.B;

public class Main {
    public static void main(String[] args) {
//        A a = new A();
//        a.fun();
//        B b = new B();
//        b.show();

        A a = new B();
        a.show();
        B b = (B)new A();
        b.show();

    }


    public static void main1(String[] args) {
        Student student = new Student();

    }
}
