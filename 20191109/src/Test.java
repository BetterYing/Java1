import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(new StringBuilder(s).reverse().append(" "));
        }
        String str2 = sb.toString();
        str2 = reverse(str2,0,str2.length() - 1);
        str2 = str2.trim();
        System.out.println(str2);
    }






    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        int i = 0;
        int j = 0;
        int len = ch.length;
        while (i < len) {
            if (ch[i] == ' ' ){
                str = reverse(str,j,i - 1);
                j = i + 1;
            } else if (i == len -1) {
                str = reverse(str,j,i);
            }
            i++;
        }
        System.out.println(str);
    }
    public static String reverse(String str,int start,int end) {
        char[] value = str.toCharArray();
        while (start < end) {
            char tmp = value[start];
            value[start] = value[end];
            value[end] = tmp;
            start++;
            end--;
        }
        return String.copyValueOf(value);
    }
}
