import java.util.Scanner;

public class Main {
    private static final int[] W = {17 * 29,29,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] array1 = sc.next().split("\\.");
            String[] array2 = sc.next().split("\\.");
            int ret1 = fun(array1);
            int ret2 = fun(array2);
            int ha = ret2 - ret1;
            if (ret1 > ret2) {
                System.out.print("-");
                ha = -ha;
            }
            System.out.println(ha / W[0] + "." + ha % W[0] / W[1] + "." + ha % W[0] % W[1] / W[2]);
        }
    }

    public static int fun (String[] array) {
        int ga = Integer.parseInt(array[0]);
        int si = Integer.parseInt(array[1]);
        int ku = Integer.parseInt(array[2]);
        int sum = ga * W[0] + si * W[1] + ku * W[2];
        return sum;
    }
}
