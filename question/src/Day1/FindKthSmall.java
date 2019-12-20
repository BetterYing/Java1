package Day1;

import java.util.*;
//第K小 遇到重复的不算
public class FindKthSmall {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Arrays.sort(arr);//从小到大排序
            int ret = 0;
            int tmp = 1;
            for (int i = 1;i < arr.length;i++) {
                if (arr[i] == arr[i - 1]) {
                    continue;
                } else {
                    tmp++;
                }
                if (tmp == k) {
                    ret = arr[i];
                }
            }
            System.out.println(ret);
        }
    }
}
