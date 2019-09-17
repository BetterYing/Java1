import java.util.Scanner;


// 编写代码模拟三次密码输入的场景。 
// 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 
// 可以重新输入，最多输入三次。三次均错，则提示退出程序 

public class Demon3{
    public static void main(String[] args){
        //char[] psw = "123456";
        int i = 0;
        int j = 0;
        Scanner sc = new Scanner(System.in);
        for(i = 0;i < 3;i++){
            //Scanner sc = new Scanner(System.in);
            System.out.println("please input : ");
            String name = sc.nextline();
            if(strcmp(psw,"123456") == 0){
                break;
            }
            if(i == 3){
                System.out.println("exit");
            } else {
                System.out.println("log in");
            }
        }
        sc.close();
    }
}