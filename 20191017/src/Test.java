import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入年龄：");
//        int age1 = scanner.nextInt();
//        age(age1);

        //System.out.println("输入一个数");
        //int num = scanner.nextInt();
        //boolean ret = prime(num);
        //System.out.println(ret);

        //func();
        //leapYear();
        //mul();

//        System.out.println("输入两个数");
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//        int ret = func1(num1,num2);
//        System.out.println(ret);

        //int num = scanner.nextInt();
        //System.out.println(func2(num));

        //int ret = numOfNine(100);
        //System.out.println(ret);

//        System.out.println("请输入数字");
//        int num = scanner.nextInt();
//        waterFlower(num);

        //passWord();

        /*
        System.out.println("输入一个数：");
        int num = scanner.nextInt();
        int ret = numOfOne(num);
        System.out.println(ret);
        */
        //func3(15);

        //func4(1234);

        toGuess();
        scanner.close();
    }


    public static void age(int age) {
        //根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        if (age > 0 && age <= 18){
            System.out.println("少年");
        } else if (age > 18 && age <= 28) {
            System.out.println("青年");
        } else if (age > 28 && age <= 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }

    public static boolean prime(int num){
        //判定一个数字是否是素数
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0){
//                return false;
//            }
//        }
//        return true;
        for(int i = 2; i <= Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void func(){
        int i ;
        //打印 1 - 100 之间所有的素数
        for (int num = 1;num <= 100;num++){
            for(i = 2; i <= num;i++){
                if (num % i == 0){
                    break;
                }
            }
            if (num == i){
                System.out.println(num);
            }
        }
    }

    //输出 1000 - 2000 之间所有的闰年
    public static void leapYear(){
        for (int i = 1000;i <= 2000;i++){
            if (i % 100 != 0 && i % 4 ==0 || i % 400 == 0 ){
                System.out.println(i);
            }
        }
    }
    //输出乘法口诀表
    public static void mul(){
        int i;
        int j;
        int num = 9;
        for (i = 1; i <= num;i++){
            for (j = 1;j <= i;j++){
                System.out.print(j + " * " + i + " = " + j*i + " ");
            }
            System.out.println();
        }
    }

    //求两个正整数的最大公约数
    public static int func1(int num1,int num2){
        int c = 0;
        while (num1 % num2 != 0){
            c = num1 % num2;
            num1 = num2;
            num2 = c;
        }
        return c;
    }

    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static double func2(int num){
        int flag = 1;
        double sum = 0.0;
        //自己的错误 i=0 导致程序运行错误(错误类型：Infinity)
        for (int i = 1;i <= num;i++){
            sum = sum + flag * 1.0 / i;
            flag = -flag;
        }
        return sum;
    }

    //编写程序数一下 1到 100 的所有整数中
    // 出现多少个数字9。
    public static int numOfNine(int num){
        int count = 0;
        for (int i = 1;i <= num;i++) {
            if (i % 10 == 9){
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        return count;
    }

    //求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
    //身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
    public static void waterFlower(int num){
        for (int i = 0;i <= num;i++) {
            int sum = 0; //保存每一位数字的次方和
            int count = 0;//记录当前数字的位数
            int tmp = i;
            //求i是几位数
            while (tmp != 0){
                count++;
                tmp = tmp / 10;
            }
            tmp = i;
            //求tmp的每一位上的数字
            while (tmp != 0){
                sum = sum + (int)Math.pow(tmp % 10,count);
                tmp = tmp / 10;
            }
            if (sum == i){
                System.out.println(i);
            }
        }
    }

    //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
    //入，最多输入三次。三次均错，则提示退出程序
    public static void passWord(){
        Scanner sc = new Scanner(System.in);
        int count = 3;
        while (count != 0){
            System.out.println("输入你的密码：");

            String password = sc.nextLine();
            if (password.equals("abcde")){
                System.out.println("登陆成功");
                break;
            } else {
                count--;
                System.out.println("你还有" + count +"次机会！");
            }
        }
    }

    // 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static int numOfOne(int num) {
        int count = 0;
        while (num != 0){
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
    public static void func3(int num){
        System.out.println("奇数：");
        for (int i = 31;i >= 1;i -= 2){
            System.out.print(((num >> i) & 1) + "");
        }
        System.out.println();
        System.out.println("偶数：");
        for (int i = 30;i >= 0;i -= 2){
            System.out.print(((num >> i) & 1) + "");
        }
    }

    //输出一个整数的每一位
    public static void func4(int num){
        if (num > 9){
            func4(num / 10);
        }
        System.out.println(num % 10);
    }

    //完成猜数字游戏
    public static void toGuess(){
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess = random.nextInt(100);

        while (true) {
            System.out.println("请输入要猜的数字：");
            int num = sc.nextInt();
            if (num > guess){
                System.out.println("大了");
            } else if (num < guess) {
                System.out.println("小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
}
