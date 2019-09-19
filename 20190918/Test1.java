// 青蛙跳台阶问题
public class Test1{
    public static void main(String[] args) {
        int num = 5;
        int ret = Jump(num);
        System.out.println(ret);
    }
    public static int Jump(int num){
        if(num <= 2){
            return num;
        }
        return Jump(num - 1) + Jump(num - 2);
    }
}