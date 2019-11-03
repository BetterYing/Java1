package operation;

import book.Book;
import book.BookList;

//新增图书
public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入图书的名字");
        String name = scanner.next();
        System.out.println("请输入图书的作者");
        String author = scanner.next();
        System.out.println("请输入图书的价格");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type = scanner.next();
        //构成一本书的对象
        Book book = new Book(name,author,price,type);
        //插入到bookList中，尾插法
        int size = bookList.getUsedSize();
        bookList.setBooks(size,book);
        bookList.setUsedSize(size + 1);
    }
}

