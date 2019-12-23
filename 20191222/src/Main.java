import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =  sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        fun(array);
    }
    
    public static void fun (int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],1);
            } else {
                map.put(arr[i],map.get(arr[i]) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> a : map.entrySet()){
            if (a.getValue() % 2 == 1) {
                System.out.print(a.getKey() + " ");
            }
        }
        System.out.println();
    }
}
