import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
        }
    }

    public static void fun (String str) {
        String[] array = str.split(" ");
        String temp;
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < array.length; k++) {
            sb.append(array[k] + " ");
        }
        System.out.println(sb);
    }
}
