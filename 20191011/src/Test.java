public class Test {
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 20;
        Swap(num1,num2);
        int a = 10;
        int b = 20;
        int c = 5;
        Func(a,b,c);
    }
    public static void Func(int num1,int num2,int num3){
        int Max = 0;
        int Min = 0;
        int Max1 = (num1 > num2) ? num1 : num2;
        Max = (Max1 > num3) ? Max1 : num3;
        System.out.println("最大值：" + Max);
        int Min1 = (num1 < num2) ? num1 : num2;
        Min = (Min1 < num3) ? Min1 : num3;
        System.out.println("最小值：" + Min);
    }

    public static void Swap(int num1,int num2){
        System.out.println("交换前：num1 = " + num1 + " num2 = " + num2);
        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("交换后：num1 = " + num1 + " num2 = " + num2);
    }
}
