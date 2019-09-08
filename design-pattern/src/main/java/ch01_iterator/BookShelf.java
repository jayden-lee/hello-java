package ch01_iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate<Book> {

    private List<Book> books;
    private int last = 0;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(last, book);
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
