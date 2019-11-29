import java.util.Arrays;
import java.util.Stack;

public class Test {

    public static void main(String[] args){
//        int[] arr = {13,8,2,7,10};
//        insertSort(arr);
//        int[] arr = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
//        shellSort(arr);
//        int[] arr = {13,8,2,7,10};
//        //selectSort(arr);
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
//        quickSort1(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));

    }

    //直接插入排序
    public static void insertSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            tmp = array[i];
            while (j >= 0) {

                //如果加个=就变成不稳定排序
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //希尔排序
    public static void shell(int[] arr,int gap) {
        int tmp;
        for (int i = gap; i < arr.length; i++) {
            int j = i - gap;
            tmp = arr[i];
            while (j >= 0) {
                if (arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }
    public static void shellSort(int[] arr) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(arr,drr[i]);
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr .length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }




    //快速排序
    public static  int partition(int[] arr,int low,int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
            } else {
               break;
            }
            while (low < high && arr[low] <= tmp) {
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

    public static void quick (int[] arr,int low,int high) {
        if (high - low + 1 <= 100) {
            insert(arr,low,high);
            return;
        }
        threeNumMid(arr,low,high);


        int par = partition(arr,low,high);
        if (par > low + 1) {
            quick(arr,low,par - 1);
        }
        if (par < high - 1) {
            quick(arr,par + 1,high);
        }
    }
    public static void quickSort1(int[] arr) {
        quick(arr,0,arr.length - 1);
    }


    public static void swap(int[] arr,int low,int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
    public static void threeNumMid(int[] arr,int low,int high) {
        int mid = (low + high) / 2;
        if (arr[mid] > arr[low]) {
            swap(arr,mid,high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr,high,mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr,low,high);
        }
    }
    public static void insert(int[] arr,int low,int high) {
        for (int i = low + 1; i < high; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= low; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }


    //快排优化
    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;
        int par;
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            par = partition(arr,low,high);
            if (par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            if (par < high - 1) {
                stack.push(par + 1);
                stack.push(high);
            }
        }
    }

    //归并排序
    public static void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int s2 = mid + 1;
        int len = high - low + 1;
        int[] tmp = new int[len];
        int i = 0;

        //判断两个归并段 中 是否还有归并段有数据
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            } else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while (s2  <= high) {
            tmp[i++] = array[s2++];
        }

        for (int j = 0; j < tmp.length; j++) {
            array[low + j] = tmp[j];
        }
    }

    public static void mergeSort(int[] array,int low,int high) {
        if(low == high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }


    //非递归归并
    public static void merge1(int[] array,int gap) {
        int[] tmp = new int[array.length];
        int i = 0;

        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 >= array.length ? array.length-1 : s2 + gap - 1;
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmp[i++] = array[s1++];
                } else {
                    tmp[i++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[i++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[i++] = array[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 >= array.length ? array.length-1 : s2 + gap - 1;
        }
        //判断s1是否有数据
        while (s1 <= array.length - 1) {
            tmp[i++] = array[s1++];
        }
        //拷贝tmp到array
        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
        }
    }
    public static void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            merge1(array,gap);
        }
    }

}
