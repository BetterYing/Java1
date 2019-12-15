import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) {
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
