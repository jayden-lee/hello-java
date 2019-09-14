package ch08_abstract_factory.listfactory;

import ch08_abstract_factory.Item;
import ch08_abstract_factory.Tray;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li>\n");
        stringBuilder.append(caption + "\n");
        stringBuilder.append("<ul>\n");

        for (Item item : trayList) {
            stringBuilder.append(item.makeHTML());
        }

        stringBuilder.append("</ul>\n");
        stringBuilder.append("</li>\n");

        return stringBuilder.toString();
    }
}
