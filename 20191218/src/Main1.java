import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = a * b;
            if (a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            while (true) {
                int ret = a % b;
                int num;
                if (ret == 0) {
                    num = c / b;
                    System.out.println(num);
                    break;
                } else {
                    a = b;
                    b = ret;
                }
            }
        }
    }
}
