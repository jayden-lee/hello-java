package ch13_visitor;

/**
 * 방문자(Visitor)를 받아들이는 인터페이스
 */
public interface Element {

    void accept(Visitor visitor);
}
