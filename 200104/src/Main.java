import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int monthCount = sc.nextInt();
        int sum = getTotalCount(monthCount);
        System.out.println(sum);

    }
    public static int getTotalCount (int monthCount) {
        if (monthCount <= 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }
}
