import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] array = new int[6];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            double x = array[3] - array[0];
            double y = array[4] - array[1];
            double z = array[5] - array[2];
            double ban = Math.sqrt (x * x + y * y + z * z);
            double ti = Math.pow(ban,3) * Math.PI * (4 / 3.0);
            System.out.printf("%.2f ",ban) ;
            System.out.printf("%.2f",ti);
        }
    }
}
