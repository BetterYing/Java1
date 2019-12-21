import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int ret = fib (num);
            System.out.println(ret);
        }
    }

    public static int fib (int num) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        if (num < 2) {
            return num;
        }
        while (f2 < num) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        if (Math.abs(f2 - num) > Math.abs(f1 - num)) {
            return Math.abs(f1 - num);
        } else {
            return Math.abs(f2 - num);
        }
    }

}
