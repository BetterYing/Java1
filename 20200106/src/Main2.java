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
            double ret = gpa(array,score);
            System.out.printf("%.2f",ret);
        }

    }

    private static double fun (int score) {
        if (score >= 90) {
            return 4.0;
        } else if (score < 90 && score >= 85) {
            return 3.7;
        } else if (score < 85 && score >= 82) {
            return 3.3;
        } else if (score < 82 && score >= 78) {
            return 3.0;
        } else if (score < 78 && score >= 75) {
            return  2.7;
        } else if (score < 75 && score >= 72) {
            return  2.3;
        } else if (score < 72 && score >= 68) {
            return  2.0;
        } else if (score < 68 && score >= 64) {
            return  1.5;
        } else if (score < 64 && score >= 60) {
            return  1.0;
        } else {
            return 0;
        }
    }
    private static double gpa(int array[],int[] scores) {
        double sum = 0;
        int sumPower = 0;
        for (int i = 0; i < array.length; i++) {
            sumPower += array[i];
            sum += array[i] * fun(scores[i]);
        }
        return sum / sumPower;
    }
}
