import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
            System.out.println();
        }

    }

    public static void fun(String str) {
        for (int i = 0; i < str.length(); i++) {
            char input = str.charAt(i);
            if (input >= 'A') {
                input = (char)(input > 'E' ? input - 5 : input + 21);
            }
            System.out.print(input);
        }
        System.out.println();
    }
}
