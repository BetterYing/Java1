import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String[] array = new String[num];
            for (int i = 0; i < num; i++) {
                array[i] = sc.next();
            }
            method(array,num);
        }
    }
    private static void method(String[] str,int n){
        String temp;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(methodB(str[i], str[j])){
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        for (int m = 0; m < n; m++) {
            System.out.println(str[m]);
        }
    }
    private static boolean methodB(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        if (len1 > len2){
            return true;
        } else if (len1 < len2){
            return false;
        } else {
            if(a.compareTo(b) > 0){
                return true;
            } else {
                return false;
            }
        }
    }
}