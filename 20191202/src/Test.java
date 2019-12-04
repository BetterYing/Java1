import java.util.*;

public class Test {
    public static void main1(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] arr = {1, 2, 2, 1, 5};
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        System.out.println(set);
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    public static void main2(String[] args) {
        int[] arr = {2, 6, 7, 8, 4, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();//期望的
        String str2 = sc.nextLine();//实际的

        Set<Character> set = new HashSet<>();
        for (char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        Set<Character> setBroken = new HashSet<>();
        for (char ch : str1.toUpperCase().toCharArray()) {
            if (!set.contains(ch) && !setBroken.contains(ch)) {
                setBroken.add(ch);
                System.out.print(ch);
            }
        }
    }

    //宝石和石头
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }


}
