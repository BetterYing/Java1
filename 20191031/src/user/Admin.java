package user;

import operation.*;

public class Admin extends User {
    public Admin(String name) {
        this.name = name;
        this.operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DisplayOperation(),
                new DelOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("===hello, " + this.name + ",欢迎使用===");
        System.out.println("0.退出");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.显示所有图书");
        System.out.println("4.删除图书");
        System.out.println("=======================================");
        System.out.println("请输入选择：");
        int choice = scanner.nextInt();
        return choice;
    }

}
