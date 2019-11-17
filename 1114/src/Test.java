import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = fun(str1);
            System.out.println(str2);
        }
    }
    public static String fun(String str) {
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for(int i = 0;i < length;i++){
            if(sb.toString().indexOf(str.charAt(i)) == -1) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
