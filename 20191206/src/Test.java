import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main1(String[] args) {
        BinarySearchTerr binarySearchTerr = new BinarySearchTerr();
        binarySearchTerr.insert(5);
        binarySearchTerr.insert(2);
        binarySearchTerr.insert(9);
        binarySearchTerr.insert(8);
        binarySearchTerr.insert(7);
        binarySearchTerr.insert(4);
        binarySearchTerr.insert(3);
        binarySearchTerr.insert(0);
        binarySearchTerr.insert(1);
        binarySearchTerr.insert(6);
        binarySearchTerr.inorder(binarySearchTerr.root);
        System.out.println();
        int ret = binarySearchTerr.search(3);
        System.out.println(ret);
    }


    public static int first(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Integer num = map.get(ch[i]);
            if (num == null) {
                map.put(ch[i],1);
            } else {
                num++;
                map.put(ch[i],num);
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main2(String[] args){
        String s = "loveleetcode" ;
        int ret = first(s);
        System.out.println(ret);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            } else {
                continue;
            }
        }
        int len = set2.size(), k = 0;
        int[] ans = new int[len];
        for(int n : set2){
            ans[k++] = n;
        }
        return ans;
    }
    public static void main3(String[] args){
         int[] num1 = {1,2,4,1};
         int[] num2 = {2,4,5,7};
         int[] ret = intersection(num1,num2);
         for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
         }
         System.out.println();
    }



    public static int[] intersect(int[] nums1, int[] nums2) {




        return null;
    }



    public static void main(String[] args){
        int[] num1 = {1,2,4,1};
        int[] num2 = {2,4,5,7};
        int[] ret = intersect(num1,num2);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();
    }

}
