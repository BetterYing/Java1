package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("输入需要删除的书籍名称");
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
        for (int j = i;j < bookList.getUsedSize() - 1;j++) {
            Book book = bookList.getBooks(j + 1);
            bookList.setBooks(j + 1,book);
        }
        bookList.setUsedSize(bookList.getUsedSize() - 1);
    }
}
