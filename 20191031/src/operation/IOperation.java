package operation;

import book.BookList;

import java.util.Scanner;

public interface IOperation {
    void work(BookList bookList);//接口方法默认public abstract
    Scanner scanner = new Scanner(System.in);


}
