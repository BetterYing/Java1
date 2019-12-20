package Day1;

import java.util.Scanner;

//输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
public class CountPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            //String str3 = str1.substring(0,i) + str2 + str1.substring(i);

            StringBuffer sb = new StringBuffer(str1);
            sb.insert(i,str2);
            if(isPalindrome(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPalindrome (String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
