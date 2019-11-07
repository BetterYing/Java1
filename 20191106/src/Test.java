import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        fun(stringBuffer);
        System.out.println(stringBuffer);
    }
    public static void fun(StringBuffer temp) {
        Scanner sc = new Scanner(System.in);
        temp.append(sc.next()).append(sc.next());
    }
}
