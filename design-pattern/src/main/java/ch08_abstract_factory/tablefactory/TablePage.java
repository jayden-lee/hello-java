package ch08_abstract_factory.tablefactory;

import ch08_abstract_factory.Item;
import ch08_abstract_factory.Page;

public class TablePage extends Page {

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>" + title + "</title></head>\n");
        stringBuilder.append("<body>\n");
        stringBuilder.append("<h1>" + title + "</h1>\n");
        stringBuilder.append("<table>");
        for (Item item : content) {
            stringBuilder.append("<tr>" + item.makeHTML() + "</tr>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("<hr><address>" + author + "</address>");
        stringBuilder.append("</body></html>\n");
        return stringBuilder.toString();
    }
}
