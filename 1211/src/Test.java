//寻找第K大
import java.util.Arrays;
public class Test {
    public static int partition(int[] arr,int low,int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= tmp) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            } else {
                break;
            }
            while (low < high && arr[low] >= tmp) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
            } else {
                break;
            }
        }
        arr[low] = tmp;
        return low;
    }

    public static void quickSort (int[] arr,int low,int high) {
        int par = partition(arr,low,high);
        if (par > low + 1) {
            quickSort(arr,low,par - 1);
        }
        if (par < high - 1) {
            quickSort(arr,par + 1,high);
        }
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,a.length -1);
        System.out.println(Arrays.toString(a));
        int ret = 0;
        for (int i = 0; i < K; i++) {
            ret =  a[i];
        }
        return ret;
    }
    public static void main(String[] args){
        int[] arr = {2,6,7,8,3,4,5};
        int n = arr.length - 1;
        int k = 2;
        int ret = findKth(arr,n,k);
        System.out.println(ret);
    }
}
