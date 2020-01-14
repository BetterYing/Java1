import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String[] array = new String[num];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextLine();
            }
            method(array);
        }
    }
    private static void method(String[] str){
        String temp;
        for(int i = 0; i < str.length; i++){
            for(int j = i + 1; j < str.length; j++){
                if(methodB(str[i], str[j])){
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        for(String s : str){
            System.out.println(s);
        }
    }
    private static boolean methodB(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        if(len1 > len2){
            return true;
        }else if(len1 < len2){
            return false;
        }else{
            if(a.compareTo(b) > 0){
                return true;
            }else{
                return false;
            }
        }
    }
}
