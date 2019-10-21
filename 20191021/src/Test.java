import java.util.Arrays;
public class Test {
    public static void main(String[] args){
        int[] array = {21,23,4,5,67,33,17,8};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] arr){
        boolean flg = false;
        //趟数
        for(int i = 0;i < arr.length - 1;i++){
            flg = false;
            //每一趟的次数
            for (int j = 0;j < arr.length - 1 - i;j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flg = true;
                }
            }
            if (!flg){
                break;
            }
        }
    }

}
