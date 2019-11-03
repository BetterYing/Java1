import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while(true) {
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }

    public static User login() {
        System.out.println("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请选择你的身份：1-----管理员 0-----普通用户");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }

}



