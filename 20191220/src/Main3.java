import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(countWays(x, y));
    }

    public static int countWays(int x, int y) {
        // write code here
        int[][] arr = new int[x][y];
        arr[0][0] = 1;
        for (int i = 1; i < x; i++) {
            arr[i][0] = arr[i - 1][0];
        }
        for (int i = 1; i < y; i++) {
            arr[0][i] = arr[0][i - 1];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[x - 1][y - 1];
    }
}