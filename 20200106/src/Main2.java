import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            int[] score = new int[n];
            for (int i = 0; i < score.length; i++) {
                score[i] = sc.nextInt();
            }
            double ret = fun(score);
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            System.out.printf("%.2f",ret / sum);
        }

    }

    private static double fun (int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 90) {
                sum += 4.0;
            } else if (array[i] < 90 && array[i] >= 85) {
                sum += 3.7;
            } else if (array[i] < 85 && array[i] >= 82) {
                sum += 3.3;
            } else if (array[i] < 82 && array[i] >= 78) {
                sum += 3.0;
            } else if (array[i] < 78 && array[i] >= 75) {
                sum += 2.7;
            } else if (array[i] < 75 && array[i] >= 72) {
                sum += 2.3;
            } else if (array[i] < 72 && array[i] >= 68) {
                sum += 2.0;
            } else if (array[i] < 68 && array[i] >= 64) {
                sum += 1.5;
            }else if (array[i] < 64 && array[i] >= 60) {
                sum += 1.0;
            }else {
                sum += 0;
            }
        }
        return sum;
    }
}
