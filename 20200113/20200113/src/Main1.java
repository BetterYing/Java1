import java.util.*;

public class Main1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            boolean ret = fun(num);
            if (ret) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
        }
    }
    public static boolean fun (int n) {
        int m = 0;
        if(n < 10){
            m = (n * n) % 10;
        } else if (n < 100){
            m = (n * n) % 100;
        } else {
            return false;
        }
        if(n == m) {
            return true;
        } else {
            return false;
        }
    }
}