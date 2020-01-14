import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0;i < array.length;i++) {
                array[i] = sc.nextInt();
            }
            fun(array,sum);
        }
    }
    public static void fun (int[] array,int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >= 0; j--) {
                int all = array[i] + array[j];
                if (!map.containsKey(all)) {
                    map.put(all,count);
                } else {
                    Integer in = map.get(all);
                    map.put(all, in+=1);
                }
            }
        }
        for(Map.Entry<Integer, Integer> a : map.entrySet()){
            if (a.getKey() == sum) {
                //System.out.println(a.getKey());
                System.out.println(a.getValue());
            }
        }
    }
}