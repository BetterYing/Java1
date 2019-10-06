public class Test {
    public static void main(String[] args){
        Person xiaoli = new Person("小丽","女",23,false);
        Person xiaofang = new Person("小芳","女",18,false);
        xiaoli.show();
        xiaofang.show();;
        xiaoli.eat();
        xiaofang.sleep();
    }
}
