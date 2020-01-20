import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String output = sc.nextLine();
            fun(input,output);
        }
    }
    public static void fun (String input,String output) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if (output.indexOf(input.charAt(i)) == -1) {
                sb.append(input.charAt(i));
            }
        }
        String s = sb.toString().toUpperCase();
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (sb1.indexOf(s.charAt(i)+"") == -1) {
                sb1.append(s.charAt(i));
            }
        }
        System.out.println(sb1);
    }
}