import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //func(arr);
        //String newArr = Arrays.toString(arr);
        //System.out.println(newArr);
        int left = 0;
        int right = arr.length - 1;
        int ret = binarySearch2(arr,left,right,3);
        System.out.println(ret);
    }

    public static int[] func(int[] array){
        int i = 0;
        int j = array.length - 1;
        while (i != j) {
            while (i < j && array[i] % 2 == 0){
                i++;
            }
            while (i < j && array[j] % 2 != 0){
                j--;
            }
            if (i != j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
             }
        }
        return array;
    }

    //二分查找
    public static int binarySearch(int[] array,int key){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if (array[mid] < key){
                left = mid + 1;
            } else if (array[mid] > key){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] array,int left,int right,int key){
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == key) {
            return mid;
        } else if (array[mid] > key) {
            right = mid - 1;
            return binarySearch2(array,left,right,key);
        } else {
            left = mid + 1;
            return binarySearch2(array,left,right,key);
        }
    }

}
