public class Main1 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(countNumberOf2s(num));
    }

    public static int countNumberOf2s(int n) {
        int result = 0;
        for(int i = 1;i <= n;i *= 10) {
            int a = n / i;
            int b = n % i;
            result += (a + 7) / 10 * i + (a % 10 == 2 ? b + 1 : 0);
        }
        return result;
    }

    public static int countNumberOf2s1(int n) {
        // write code here
        int count = 0;
        for (int i = 0;i <= n ;i++) {
            if (i % 10 == 2) {
                count++;
            }
            if (i / 10 == 2) {
                count++;
            }
        }
        return count;
    }
}
