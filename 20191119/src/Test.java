import java.util.Scanner;
public class Test {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1=sc.next();
            String str2=sc.next();
            int ret = func(str1,str2);//测试是否包含
            System.out.println(ret);
        }
    }


    public static int func(String str1,String str2) {
        if(str1.contains(str2) || str2.contains(str1)) {
            return 1;
        }
        return 0;
    }
}
