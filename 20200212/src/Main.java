import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String num = maxNum(str);
            System.out.println(num);
        }
    }
    private static String maxNum (String str) {
        char[] ch = str.toCharArray();
        String s = new String();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                s += ch[i];
            } else {
                s += " ";
            }
        }
        String[] st = s.split(" ");
        int maxn = st[0].length();
        String result = null;
        for (int i = 0; i < st.length; i++) {
            if (st[i].length() > maxn) {
                maxn = st[i].length();
                result = st[i];
            }
        }
        return result;
    }
}
