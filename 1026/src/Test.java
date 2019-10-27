import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int a = 16;
        int b = 5;
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(a,b));
        System.out.println(calculator.sub(a,b));
        System.out.println(calculator.mul(a,b));
        System.out.println(calculator.div(a,b));

        Person xiaohong = new Person("xiaohong",14);
        xiaohong.sleep();
        xiaohong.eat();

        Person xiaoli = new Person("xiaoli",25);
        xiaoli.eat();

        int[] arr = {23,45};
        swap(arr);
        for (int x :arr) {
            System.out.println("交换后的数字是：" + x);
        }
    }

    public static void swap(int[] b){
        for (int i = 0; i < b.length-1; i++) {
            int temp = b[i];
            b[i] = b[i + 1];
            b[i + 1] = temp;
        }
    }

}
