import java.util.Arrays;

public class Sort {
    //插入排序
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //希尔排序
    public static void shell(int[] array,int gap){
        for (int i = gap; i < array.length; i += 1) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0 ; j = j - gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }

    }
    public static void shellSort(int[] array) {
        int[] a = {5,3,1};
        for (int i = 0; i < a.length; i++) {
            shell(array,a[i]);
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //堆排序
    public static void adjustDown (int[] array,int root,int len) {
        int parent = root;
        int child = parent * 2 + 1;
        while (child < len) {
            if (array[child] < array[child + 1] && child + 1 < len) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }
    public static void heapSort (int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
        //每次调整结束位置
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        Boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    //快速排序
    public static int partition(int[] arr,int low,int high) {
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

            while (low < high && arr[low] < tmp) {
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
        int par = partition(arr,low,high);
        if(par > low+1) {
            quick(arr,low,par-1);
        }
        if(par < high-1) {
            quick(arr,par+1,high);
        }
    }
    public static void quickSort (int[] arr) {
        quick(arr,0,arr.length - 1);
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


    public static void main(String[] args){
        int[] arr = {1,5,8,9,34,2,12,23,25,18,11,15,28,39,30};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
