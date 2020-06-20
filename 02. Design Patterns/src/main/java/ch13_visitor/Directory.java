package ch13_visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

    private String name;

    private List<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return dir.stream().mapToInt(Entry::getSize).sum();
    }

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        dir.add(entry);
        return this;
    }

    @Override
    public List<Entry> getEntries() throws FileTreatmentException {
        return dir;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
