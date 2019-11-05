import java.util.Arrays;

public class Demon {
    public static void main(String[] args) {
        String str = "abcdef";
        String ret = reverse(str);
        System.out.println(ret);
    }
    
    public static String reverse(String str) {
        char[] data = str.toCharArray();
        int i = 0;
        int j = data.length - 1;
        while(i < j) {
            char tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
            i++;
            j--;
        }
        return new String(data);
    }

}
