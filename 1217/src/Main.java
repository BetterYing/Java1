import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        String ret = func(strings);
        System.out.println(ret);
    }

    public static String func(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        int value = 1;
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i],value);
            } else {
                value = map.get(s[i]);//得到要放元素的位置
                value++;
                map.put(s[i],value);
            }
        }
        System.out.println(map);//查看map
        for (int i = 0; i < s.length; i++) {
            if (map.get(s[i]) >= (s.length / 2)) {
                return s[i];
            }
        }
        return null;
    }
}
