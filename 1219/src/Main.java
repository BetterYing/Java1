import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int num = Integer.parseInt(arr[arr.length - 1]);
        int[] ret = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            ret[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(ret);


        for (int i = 0; i < num; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();
    }
}
