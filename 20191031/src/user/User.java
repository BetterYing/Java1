package user;

import book.BookList;
import operation.IOperation;

import java.util.Scanner;

public abstract class User {
    protected String name;
    protected IOperation[] operations;
    Scanner scanner = new Scanner(System.in);

    //根据用户输入选项进行操作
    public void doOperation (int choice, BookList bookList) {
        /*接口数组可以保存operation数组里有什么元素*/
        operations[choice].work(bookList);//把menu的返回值作为choice的参数
    }

    public abstract int menu();

}
