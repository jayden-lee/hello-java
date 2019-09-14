package ch08_abstract_factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {

    protected List<Item> trayList = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        trayList.add(item);
    }
}
