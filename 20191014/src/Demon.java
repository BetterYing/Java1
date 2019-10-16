public class Demon {
    public static void main(String[] args){
        String name = "zhangsan";
        System.out.println(name);







    }

    public static void main2(String[] args){
        boolean value = true;
        System.out.println(value);


//        byte value = 0;
//        System.out.println(value);

        //float num = 1.0f;
        //System.out.println(num);

//        int maxValue = Integer.MAX_VALUE;
//        System.out.println(maxValue + 1);

//        System.out.println(Integer.MAX_VALUE); //2147483647
//        System.out.println(Integer.MIN_VALUE);//-2147483648


    }



    public static void main1(String[] args) {
        int age = 3;
        String name = "66";
        Dog dog = new Dog(name, age);
        int x = age - 1;
        if (x > 1) {
            dog.play();
        } else {
            dog.bark();
        }
    }
}

class Dog {
    private String name;
    private Integer age;
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public void play(){
        System.out.println(this.name + " want to play");
    }
    public void bark() {
        System.out.println(this.name + " wangwang");
    }
}
