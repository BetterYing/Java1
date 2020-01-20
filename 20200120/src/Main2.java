public class Main2 {
    public static void main(String[] args) {
        fun();
    }
    public static void fun() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 30; i++) {
            sum1 += 10;
            sum2 += Math.pow(2,i);
        }
        System.out.println(sum1 + " " + sum2);
    }
}
