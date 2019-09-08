package ch01_iterator;

/**
 * 반복자 인터페이스
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
