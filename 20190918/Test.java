public class Test{
    public static void main(String[] args) {
        int num = 5;
        int ret = fib(num);
        System.out.println(ret);
    }
    public static int fib(int num){
        if(num == 1 || num == 2){
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}