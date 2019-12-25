import java.util.*;

public class Main2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.nextLine();
        fun (num,str);
    }

    public static void fun (int num,String str) {
        for (int i = 0; i < num; i++) {
            System.out.print(str);
        }
        System.out.println();
        for (int i = 0; i < num / 2 - 2; i++) {
            System.out.print(str);
            for (int j = 1; j < num - 1; j++) {
                System.out.print(" ");
            }
            System.out.println(str);
        }

        for (int i = 0; i < num; i++) {
            System.out.print(str);
        }

//        int line = (int) (num * 0.5 + 0.5);
//        for (int i = 0; i < line; i++) {
//            if (i == 0 || i == line - 1) {
//                for (int j = 0; j < num; j++) {
//                    System.out.print(str);
//                }
//                System.out.println();
//            } else {
//                System.out.print(str);
//                for (int j = 1; j < num - 1; j++) {
//                    System.out.print(" ");
//                }
//                System.out.println(str);
//            }
//        }
    }




}