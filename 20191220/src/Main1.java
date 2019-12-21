import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            while(num / 5 != 0){
                num = num / 5;
                count += num;
            }
            System.out.println(count);
        }
    }

    public static int mul (int num) {
        if (num == 1) {
            return num;
        }
        return num * mul(num - 1);
    }

}
