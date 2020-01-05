import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String origin = sc.nextLine();
            String need = sc.nextLine();
            fun(origin,need);
        }
    }
    public static void fun (String origin,String need) {
        Map<Character,Integer> map = new HashMap<>();
        char[] array = origin.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                int count = map.get(array[i]);
                map.put(array[i],count+1);
            }else {
                map.put(array[i],1);
            }
        }


    }
}
