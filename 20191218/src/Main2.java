import java.util.Scanner;

public class Main2 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w % 4 == 0 || h % 4 == 0) {
                System.out.println(w * h / 2);
            } else if (w % 2 == 0 && h % 2 == 0) {
                System.out.println(w * h / 2 + 2);
            } else {
                System.out.println(w * h / 2 + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[][] arr = new int[w][h];
            int count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (arr[i][j] != -1) {
                        count++;
                        if (i + 2 < w) {
                            arr[i + 2][j] = -1;
                        }
                        if (j + 2 < h) {
                            arr[i][j + 2] = -1;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
