package ch08_abstract_factory.listfactory;

import ch08_abstract_factory.Item;
import ch08_abstract_factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    public String makeHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title>" + title + "</title></head>\n");
        stringBuilder.append("<body>\n");
        stringBuilder.append("<h1>" + title + "</h1>\n");

        stringBuilder.append("<ul>\n");
        for (Item item : content) {
            stringBuilder.append(item.makeHTML());
        }
        stringBuilder.append("</ul>\n");

        stringBuilder.append("<hr><address>" + author + "</address>");
        stringBuilder.append("</body></html>\n");
        return stringBuilder.toString();
    }
}
