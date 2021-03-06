import java.util.Arrays;

public class Main1 {
    public static String[] getGray(int n) {
        // write code here
        String[] ret = null;
        if (n == 1) {
            ret = new String[]{"0","1"};
        } else {
            String[] strs = getGray(n - 1);
            ret = new String[2 * strs.length];
            for (int i = 0; i < strs.length; i++) {
                ret[i] = "0" + strs[i];
                ret[ret.length - 1 - i] = "1" + strs[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int num = 2;
        String[] str = getGray(num);
        System.out.println(Arrays.toString(str));
    }
}
