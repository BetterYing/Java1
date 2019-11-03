package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入需要归还的书籍名称");
        String name = scanner.next();
        Book book = null;
        int i;
        for (i = 0;i < bookList.getUsedSize();i++) {
            if (name.equals(bookList.getBooks(i).getName())){
                book = bookList.getBooks(i);
                break;
            }
        }
        if (i >= bookList.getUsedSize()) {
            System.out.println("没有此书");
            return;
        }
        //找到了这本书，没有借出去
        //找到了这本书，借出去了
        if (book != null && !book.isBorrowed()){
            System.out.println("此书没有被您借阅");
            return;
        }
        if (book != null && book.isBorrowed()){
            book.setBorrowed(false);
        }
        System.out.println("归还成功！");
    }
}
