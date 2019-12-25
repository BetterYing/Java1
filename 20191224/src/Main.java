import java.util.Arrays;

public class Main {
    public static int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }

    public static void main(String[] args) {
        int[] arr = {2,3};
        arr = exchangeAB(arr);
        System.out.println(Arrays.toString(arr));

    }
}