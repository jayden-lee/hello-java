package ch07_builder;

import java.util.List;

/**
 * 문서를 만드는 추상 메서드를 선언하고 있는 추상 클래스
 */
public abstract class Builder {

    public abstract void makeTitle(String title);

    public abstract void makeContent(String content);

    public abstract void makeItems(List<String> items);

    public abstract void close();
}
