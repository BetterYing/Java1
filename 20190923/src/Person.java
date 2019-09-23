public class Person {
    public String name = "";
    public String sex;
    public int age;

    public static int num = 0;

    public Person(String name){
        this.name = name;
    }

    public void eat(){
        //this 表示当前对象的引用
        System.out.println(this.name + "吃饭");
    }
    public void sleep(){
        System.out.println(this.name + "睡觉");
    }
}
