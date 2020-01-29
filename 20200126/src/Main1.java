import java.util.ArrayList;
import java.util.List;

/**
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数
 */
public class Main1 {
    public static void main(String[] args) {
        int start = 0;
        int end = 10000;
        List<Integer> list = test(start,end);
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static boolean isSquare(int num) {
        if (Math.sqrt(num) % 1 == 0) {
            return true;
        }
        return false;
    }
    public static List<Integer> test (int start,int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isSquare(i + 100) && isSquare(i + 100 + 168)) {
                list.add(i);
            }
        }
        return list;
    }
}
