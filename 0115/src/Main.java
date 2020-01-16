import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
        }
    }
    public static void fun (String string) {
        for(int i = 0; i < string.length(); i++) {
            int num = string.charAt(i) - '\0';
            String s = Integer.toBinaryString(num);
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < s.length(); j++) {
                if(j < 7-s.length()) {
                    stringBuilder.append("0");
                }
                if(s.charAt(j) == '1') {
                    count++;
                }
            }
            stringBuilder.append(s);
            if(count % 2 == 1){
                System.out.println("0"+stringBuilder.toString());
            } else {
                System.out.println("1"+stringBuilder.toString());
            }
        }

    }
}