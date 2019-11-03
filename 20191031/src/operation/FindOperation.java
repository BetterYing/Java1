package operation;

import book.BookList;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入需要查找的书籍名称");
        String name = scanner.next();
        int i;
        for (i = 0;i < bookList.getUsedSize();i++) {
            if (name.equals(bookList.getBooks(i).getName())){
                System.out.println(bookList.getBooks(i));
                return;
            }
        }
        if (i > bookList.getUsedSize()) {
            System.out.println("没有找到此书");
        }
        System.out.println("查找完毕");
    }
}
