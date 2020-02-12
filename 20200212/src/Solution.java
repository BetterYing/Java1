import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[i]) {
                    int tmp = 0;
                    tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(input,k);
        for (int i: list ) {
            if (i != list.get(list.size() - 1)) {
                System.out.print(i + ",");
            } else {
                System.out.println(list.get(list.size() - 1));

            }
        }
    }
}