//统计回文数
import java.util.Scanner;

public class Main3 {
    public static boolean isPalindrome(String str1) {
        int i = 0;
        int j = str1.length() - 1;
        while (i < j) {
            if (str1.charAt(i) == str1.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count=0;
        for(int i = 0;i <= str1.length();i++){
            String str3 = str1.substring(0,i) + str2 + str1.substring(i);
            if(isPalindrome(str3)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
