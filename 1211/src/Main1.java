//下厨房

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.toUpperCase().split(" ");
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }
}
