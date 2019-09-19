public class Demon{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        print(arr);
        // System.out.println("length:" + arr.length);

        // System.out.println(arr[1]);
        // System.out.println(arr[0]);

        // arr[2] = 100;
        // System.out.println(arr[2]);

        //for(int i = 0;i < arr.length;i++){
        //   System.out.println(arr[i]);
        //    }
        // for (int x : arr){
        //     System.out.println(x);
        // }

    }
    public static void print(int[] a){
        for (int x : a){
            System.out.println(x);
        }
    }
}