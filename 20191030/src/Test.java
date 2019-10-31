interface A {

}
interface B {
    void func1();
}
interface C extends B{
    void func2();
}

class D implements C {

    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

}

public class Test {
    public static void main(String[] args){

    }
}
