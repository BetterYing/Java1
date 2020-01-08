import java.util.*;

public class Main1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < num.length;i++) {
                num[i] =  sc.nextInt();
            }
            for (int i = 0;i < m;i++) {
                char c = sc.next().charAt(0);
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (c == 'Q') {
                    //Q表示询问，问id从a，b中成绩最高的是谁
                    int ret = max(a - 1,b - 1,num);
                    System.out.println(ret);
                } else {
                    //U更新操作，把A的成绩改为B
                    num[a - 1] = b;
                }
            }
        }
    }
    private static int max(int start, int end, int[] array) {
        if (start > end) {
            return max(end, start, array);
        }
        int max = array[start];
        for (int i = start + 1; i < end + 1; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
