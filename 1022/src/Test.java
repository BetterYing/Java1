public class Test {
    public static void main(String[] args){
        int ret = mul(5);
        System.out.println(ret);
        int ret2 = sum(10);
        System.out.println(ret2);
        func(1234);
        int ret3 = sum2(1234);
        System.out.println(ret3);
        System.out.println(fib(5));
        System.out.println(func3(5));

    }
    //阶乘
    public static int mul(int num) {
        if (num == 1) {
            return 1;
        }
        return num * mul(num - 1);
    }

    //递归求 1 + 2 + 3 + ... + 10
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public static void func(int num){
        if (num > 9){
            func(num / 10);
        }
        System.out.println(num % 10 + " ");
    }

    //写一个递归方法，输入一个非负整数，返回组成它的数字之和.
    public static int sum2(int num){
        if (num < 10){
            return num;
        }
        return num % 10 + sum2(num / 10);
    }

    //求斐波那契数列的第 N 项
    public static int fib(int n) {
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n - 2) + fib(n - 1);

    }

    //求解汉诺塔问题(提示, 使用递归)
    //public

    //青蛙跳台阶问题
    public static int func3(int n){
        if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else {
            return func3(n - 2) + func3(n - 1);
        }
    }
}
