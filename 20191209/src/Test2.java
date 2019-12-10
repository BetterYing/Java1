import java.util.Scanner;

public class Test2 {
    private static class MyThread extends Thread {
        private int n;
        MyThread (int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = fib(n);
            System.out.printf("fib(%d) 的计算结果为 %d\n",n,result);
        }
    }

    private static long fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入 n：");
            int n = sc.nextInt();
            Thread thread = new MyThread(n);
            thread.start();
        }
    }


}
