//空瓶子
import java.util.Scanner;

public class Main {
    public static int drink (int num) {
        int cou = 0;
        while (num > 1) {
            cou = cou + num / 3;//总共可以兑换多少
            num = num % 3 + num / 3;//空瓶子数
            if (num == 2) {
                num++;
            }
        }
        return cou;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int ret = drink(num);
            if (num == 0) {
                break;
            }
            System.out.println(ret);
        }

    }
}
