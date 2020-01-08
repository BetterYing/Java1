import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            fun(array);
        }
    }
    public static void fun (int[] array) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        double sum4 = 0.0;
        int sum5 = 0;
        int flag = 1;
        int count1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 5 == 0 ) {
                if (array[i] % 2 == 0) {
                    sum1 += array[i];
                }
            } else if (array[i] % 5 == 1){
                sum2 = sum2 + (flag * array[i]);
                flag = -flag;
            } else if (array[i] % 5 == 2) {
                sum3++;
            } else if(array[i] % 5 == 3) {
                count1++;
                sum4 += array[i];
            } else if (array[i] % 5 == 4){
                sum5 = array[i];
                if (sum5 < array[i]) {
                    sum5 = array[i];
                }
            } else {
                return;
            }
        }
        sum4 = sum4 / count1;
        System.out.print(sum1 + " ");
        System.out.print(sum2 + " ");
        System.out.print(sum3 + " ");
        System.out.printf("%.1f ",sum4);
        System.out.print(sum5 + " ");
    }
}
