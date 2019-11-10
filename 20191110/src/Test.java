import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main7(String[] args){
        try {
            System.out.println(readFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String readFile() throws FileNotFoundException {
        File file = new File("d:/test.txt");
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }

    public static void main6(String[] args){
        //System.out.println(readFile());//编译出错 java.io.FileNotFoundException;
    }
    public static  String readFile1() {
        File file = new File("d:/test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc.nextLine();
    }
//    public static String readFile1() {
//        //尝试打卡文件，并读其第一行
//        File file = new File("d:/test.txt");
//        //使用文件对象构造Scanner对象
//        Scanner sc = new Scanner(file);
//        return sc.nextLine();
//    }



    public static void main5(String[] args){
        System.out.println(func());

    }
    public static int func() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }


    public static void main4(String[] args){
        System.out.println(divide(10,0));
    }
    public static int divide(int x,int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("除0异常");
        }
        return x / y;
    }




    public static void main3(String[] args){
        try (Scanner sc = new Scanner(System.in)){
            int num = sc.nextInt();
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        int[] arr = {1,2,3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            //System.out.println("下标越界异常");
            e.printStackTrace();
        } finally {
            System.out.println("finally code");
        }
    }


    public static void main1(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            //打印出现异常的调用栈
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
}
