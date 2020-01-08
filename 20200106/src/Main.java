import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0;i < array.length;i++) {
                array[i] = sc.nextInt();
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] <= a) {
                    a += array[i];
                } else {
                    int ret = fun(a,array[i]);
                    //System.out.println(ret);
                    a += ret;
                }
            }
            System.out.println(a);
        }
    }
    public static int fun (int a,int b) {
        int c;
        for (int i = 0;i < i + 1;i++) {
            c = a % b;
            if(c == 0)
                break;
            else {
                a = b;
                b = c;
            }
        }
        return b;
    }
}