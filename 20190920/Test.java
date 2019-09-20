import java.util.Arrays;

public class Test{
    // public static void main(String[] args) {
    //     int num = 0;
    //     func(num);
    //     System.out.println("num = " + num);
    // }
    // public static void func(int x){
    //     x = 10;
    //     System.out.println("x = " + x);
    // }


    // public static void main(String[] args) {
    //     int[] arr = {1 ,2 , 3};
    //     func (arr);
    //     System.out.println("arr[0] = " + arr[0]);
    // }
    // public static void func(int[] a){
    //     a[0] = 10;
    //     System.out.println("a[0] = " + a[0]);
    // }



    // public static void main(String[] args) {
    //     int[] arr = {1 ,2 ,3};
    //     int[] output = transform(arr);
    //     printArray(output);
    // }
    // public static void printArray(int[] arr){
    //     for (int i = 0;i < arr.length;i++){
    //         System.out.println(arr[i]);
    //     }
    // }
    // public static int[] transform(int[] arr){
    //     int[] ret = new int[arr.length];
    //     for(int i = 0;i < arr.length;i++){
    //         ret[i] = arr[i] * 2;
    //     }
    //     return ret;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1 ,2 ,3 ,4 ,5 ,6};
    //     //String newArr = Arrays.toString(arr);
    //     System.out.println(toString(arr));
    // }
    // public static String toString(int[] arr){
    //     String ret = "[";  
    //     for (int i = 0;i < arr.length;i++){
    //         ret += arr[i];  //借助String += 进行拼接字符串
    //         if(i != arr.length - 1){
    //             ret += ", ";  //除了最后一个元素之外，其他元素后面都要加上“， ”
    //         }
    //     }
    //     ret += "]";
    //     return ret;
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1,2,3,4,5,6};
    //     int[] newArr = copyof(arr);
        
    //     //int[] newArr = Arrays.copyof(arr,arr.length);
    //     System.out.println("newArr: " + Arrays.toString(newArr));

    //     arr[0] = 10;
    //     System.out.println("arr: " + Arrays.toString(arr));
    //     System.out.println("newArr: " + Arrays.toString(newArr));
    // }
    // public static int[] copyof(int[] arr){
    //     int[] ret = new int[arr.length];
    //     for(int i = 0;i < arr.length;i++){
    //         ret[i] = arr[i];
    //     }
    //     return ret;
    // }
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,5,6};
        System.out.println(find(arr,10));
        //System.out.println(max(arr));
        //System.out.println(avg(arr));

    }
    public static int max (int[] arr){
        int max = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static double avg(int[] arr){
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        return (double)sum / (double)arr.length;
    }
    public static int find(int[] arr, int toFind) {     
        for (int i = 0; i < arr.length; i++) {         
            if (arr[i] == toFind) {             
                return i;         
            }     
        }
        return -1;
    }
}