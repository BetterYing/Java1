package operation;

import book.Book;
import book.BookList;

public class borrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入需要借阅的书籍名称");
        String name = scanner.next();
        int i;
        for (i = 0;i < bookList.getUsedSize();i++) {
            if (name.equals(bookList.getBooks(i).getName())){
                break;
            }
        }
        if (i >= bookList.getUsedSize()) {
            System.out.println("没有找到此书");
            return;
        }
        //i为此时借阅书籍的下标
        Book book = bookList.getBooks(i);
        if (book.isBorrowed()) {
            System.out.println("此书已经被借出！");
        } else {
            book.setBorrowed(true);
            System.out.println("借阅成功");
        }
    }
}
