package Day1;

import java.util.Arrays;
import java.util.Scanner;

//寻找第K大
public class FindKthBig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sarr = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[sarr.length];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(sarr[i]);
        }
        findKth(array,0,array.length -1);
        System.out.println(Arrays.toString(array));
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret = array[i];
        }
        System.out.println(ret);
    }


    public static void findKth (int[] array,int low,int high) {
        int par = partition(array,low,high);
        if (par > low + 1) {
            findKth(array,low,par - 1);
        }
        if (par < high - 1) {
            findKth(array,par + 1,high);
        }
    }

    public static int partition (int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] <= tmp) {
                high--;
            }
            if (low < high) {
                array[low] = array[high];
            }
            while (low < high && array[low] >= tmp) {
                low++;
            }
            if (low < high) {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

}
