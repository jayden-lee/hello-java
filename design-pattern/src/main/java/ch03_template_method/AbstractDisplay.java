package ch03_template_method;

import java.util.stream.IntStream;

public abstract class AbstractDisplay {

    abstract void open();

    abstract void print();

    abstract void close();

    public final void display(){
        open();

        IntStream.range(0, 5).forEach(i -> print());

        close();
    }
}
