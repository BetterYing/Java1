public class Main {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1,10};
        System.out.println(CountPrime(arr));
    }

    public static int CountPrime (int[] Range) {
        if (Range[0] > Range[1]) {
            return 0;
        }
        int count = 0;
        for (int i = Range[0];i <= Range[1];i++) {
            if (i == 1 || i == 2) {
                count++;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        break;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
