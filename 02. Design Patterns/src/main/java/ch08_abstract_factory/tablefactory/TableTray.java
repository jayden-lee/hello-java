package ch08_abstract_factory.tablefactory;

import ch08_abstract_factory.Item;
import ch08_abstract_factory.Tray;

public class TableTray extends Tray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<td>");
        stringBuilder.append("<table><tr>");
        stringBuilder.append("<td><b>" + caption + "</b></td>");
        stringBuilder.append("</tr>\n");

        stringBuilder.append("<tr>\n");
        for (Item item : trayList) {
            stringBuilder.append(item.makeHTML());
        }

        stringBuilder.append("</tr></table>");
        stringBuilder.append("</td>");
        return stringBuilder.toString();
    }
}
