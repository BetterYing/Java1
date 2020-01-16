import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            //int num = sc.nextInt();
            fun(str);
        }
    }

    //E:\V1R2\product\fpgadrive.c 1325
    public static void fun (String str) {
        String[] arr = str.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}
