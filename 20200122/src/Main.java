import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x >= 'A' && x <= 'Z') {
                    if (map.containsKey(x))
                        map.replace(x, map.get(x) + 1);
                    else {
                        map.put(x, 1);
                    }
                }
            }
            for (char x = 'A'; x <= 'Z'; x++) {
                if (map.containsKey(x)) {
                    System.out.println(x + ":" + map.get(x));
                } else
                    System.out.println(x + ":0");
            }
        }
    }
}