public class Test {
    public static void main(String[] args){
        Dog mydog = new Dog();
//        mydog.breed = "萨摩";
//        mydog.age = 2;
//        mydog.sex = "公";
//        mydog.furColor = "白色";

        System.out.println(mydog.breed + "\t" + mydog.age +
                "\t" + mydog.sex + "\t" + mydog.furColor);
        mydog.eat();
        mydog.sleep();
    }
}
