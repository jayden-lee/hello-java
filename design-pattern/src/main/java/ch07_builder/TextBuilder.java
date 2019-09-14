package ch07_builder;

import java.util.List;

public class TextBuilder extends Builder {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        stringBuilder.append("=============================\n");
        stringBuilder.append("\"" + title + "\"");
        stringBuilder.append("\n");

    }

    @Override
    public void makeContent(String content) {
        stringBuilder.append("#" + content + "\n");
        stringBuilder.append("\n");
    }

    @Override
    public void makeItems(List<String> items) {
        for (String item : items) {
            stringBuilder.append(" >>" + item + "\n");
        }
        stringBuilder.append("\n");
    }

    @Override
    public void close() {
        stringBuilder.append("=============================\n");
    }

    public String getResult() {
        return stringBuilder.toString();
    }
}
