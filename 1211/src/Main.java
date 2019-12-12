//斐波那契变形--怎么变成离自己最近的回文函数

import java.util.Scanner;

public class Main {
    public static int fib(int num) {
        if (num < 2) {
            return num;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

    public static int fun () {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int ret = fib(i);
        for (int j = 0; j < ret; j = fib(j + 1)) {
            if (i == j) {
                return 0;
            } else if (i > j) {
                while (Math.abs(i - 1) == j) {
                    count++;
                }
            } else {
                while (Math.abs(i + 1) == j) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(fun());
    }

}
