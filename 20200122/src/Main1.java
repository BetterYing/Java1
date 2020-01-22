import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(sc.hasNext()){
            String s = str.substring(2);
            int i = Integer.parseInt(s,16);//s指的是包含要解析的整数形式的String，后面的16代表解析S 时使用的基数
            System.out.println(i);
        }
    }
}
