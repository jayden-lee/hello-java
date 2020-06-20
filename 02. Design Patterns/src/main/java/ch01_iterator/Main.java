package ch01_iterator;

public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Effective Java"));
        bookShelf.appendBook(new Book("오브젝트"));
        bookShelf.appendBook(new Book("Java 언어로 배우는 디자인 패턴 입문"));
        bookShelf.appendBook(new Book("DDD"));

        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }
}
