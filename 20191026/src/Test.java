import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        //String str = toString(arr);
        //System.out.println(str);
//        int[] arr2 = new int[arr1.length];
//        copyArray(arr1,arr2);
//        System.out.println(toString(arr2));
//
//        arr2 = Arrays.copyOf(arr1,arr1.length);
//        System.out.println(Arrays.toString(arr2));
//
//        System.arraycopy(arr1,0,arr2,0,arr1.length);
//        System.out.println(Arrays.toString(arr2));
        int[] arr2 = arr1.clone();
        System.out.println(Arrays.toString(arr2));

    }




    public static void main2(String[] args) {
        int[] array1 = {41,29,83,4,15};
//
//        int ret = Max(array1);
//        System.out.println(ret);
//
//        int ret2 = Min(array1);
//        System.out.println(ret2);
//
//        double ret3 = avg(array1);
//        System.out.println(ret3);
//
//        int[] array2 = reverse(array1);
//        System.out.println(Arrays.toString(array2));
//
//        func(array1);
//        System.out.println(Arrays.toString(array1));
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        bubbleSort(array1);
        System.out.println(Arrays.toString(array1));

    }

//    public static void bubbleSort1(int[] array){
//        //趟数是长度 - 1次
//        for (int i = 0; i < array.length - 1; i++) {
//            //每一趟的次数
//            for(int j = 0;j < array.length - 1 - i;j++) {
//                if (array[j] > array[j + 1]){
//                        int tmp = array[j];
//                        array[j] = array[j + 1];
//                        array[j + 1] = tmp;
//                }
//            }
//        }
//    }

    public static void bubbleSort(int[] array){
        boolean flag = false;
        //趟数是长度 - 1次
        for (int i = 0; i < array.length - 1; i++) {
            //每一趟的次数
            flag = false;
            for(int j = 0;j < array.length - 1 - i;j++) {
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;

                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static int Max(int[] array) {
        int tmp = array[0];
        for(int i = 1;i < array.length;i++) {
            if (tmp < array[i]) {
                tmp = array[i];
            }
        }
        return tmp;
    }

    public static int Min(int[] array) {
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (tmp > array[i]){
                tmp = array[i];
            }
        }
        return tmp;
    }

    public static double avg(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }

    public static int[] reverse(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return array;
    }

    public static int[] func(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            if (array[left] % 2 == 0 && left < right){
                left++;
            }
            if (left < right && array[right] % 2 != 0){
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
        return array;
    }


    public static String toString(int[] array) {
        String str = "[";
        for(int i = 0;i < array.length;i++) {
            str += array[i];
            if(i != array.length - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    public static void copyArray(int[] array1,int[] array2) {
        for(int i = 0;i < array1.length;i++) {
            array2[i] = array1[i];
        }
    }

    public static void main3(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i = 0;i < array.length;i ++){
            for(int j = 0;j < array[i].length;j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Arrays工具类中的方法演示
        //int[] array = {1,2,3,4,5,6};
//        int[] ret = Arrays.copyOfRange(array,2,5); //[2,5);
//        System.out.println(Arrays.toString(ret));
//
//        int[][] array2 = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(Arrays.deepToString(array2));
//
//        int[] array3 = {1,2,3,4,5,6,7};
//        System.out.println(Arrays.equals(array,array3));
        int[] array = new int[10];
        Arrays.fill(array,10);
        Arrays.fill(array,2,5,7); //[2,5) 填充
        System.out.println(Arrays.toString(array));
    }

}
