import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        fun();
    }
    public static void fun () {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 1; i < num.length; i++) {
            if (num[i] != 0) {
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        for (int i = 0; i < num.length; i++) {
            while(num[i] > 0){
                System.out.print(i);
                num[i]--;
            }
        }
        System.out.println();
    }

}
