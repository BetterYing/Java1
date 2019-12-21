import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = str.length() - 1; i >= 0 ; i--) {
                sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
