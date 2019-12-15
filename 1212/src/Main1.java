public class Main1 {
    public static int count(int[] A, int n) {
        int cou = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (A[i] > A[j]) {
                    cou++;
                }
            }
        }
        return cou;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        int ret = count(arr,arr.length - 1);
        System.out.println(ret);
    }
}
