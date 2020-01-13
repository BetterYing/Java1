import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String ret = fun(str);
            System.out.println(ret);
        }
    }

    public static String fun (String str) {
        int[] cla = new int[4];
        if (str.length() <= 8) {
            return ("NG");
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                cla[0] = 1;
            } else if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                cla[1] = 1;
            } else if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
                cla[2] = 1;
            } else {
                cla[3] = 1;
            }
        }
        if (cla[0] + cla[1] + cla[2] + cla[3] < 3) {
            return ("NG");
        }
        for(int i = 0 ; i < str.length() - 3;i++){
            String s1 = str.substring(i,i + 3);
            String s2 = str.substring(i + 3,str.length());
            if(s2.contains(s1)){
                return ("NG");
            }
        }
        return ("OK");
    }
}
