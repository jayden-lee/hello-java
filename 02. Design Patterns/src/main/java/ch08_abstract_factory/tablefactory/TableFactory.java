package ch08_abstract_factory.tablefactory;

import ch08_abstract_factory.Factory;
import ch08_abstract_factory.Link;
import ch08_abstract_factory.Page;
import ch08_abstract_factory.Tray;

public class TableFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
