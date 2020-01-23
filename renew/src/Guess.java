import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int toguess = random.nextInt(100);
        while (true) {
            System.out.println("请输入猜的数字");
            int num = sc.nextInt();
            if (num < toguess) {
                System.out.println("small");
            } else if (num > toguess) {
                System.out.println("big");
            } else {
                System.out.println("right");
                break;
            }
        }
    }
}
