public class Test2 {
    public static String delect(String str) {
        char[] arr = str.toCharArray();
        String str1 = "aeiou";
        int j = arr.length - 1;
        for (int i = 0; i < j; i++) {
            if (str1.indexOf(arr[i]) == -1) {
                continue;
            }

            for (int m = i;m < j;m++){
                arr[m] = arr[m + 1];
            }
            j--;
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "helloworld";
        str = delect(str);
        System.out.println(str);
    }


}
