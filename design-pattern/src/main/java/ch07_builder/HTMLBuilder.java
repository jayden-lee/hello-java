package ch07_builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLBuilder extends Builder {

    private String filename;
    private PrintWriter printWriter;

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";

        try {
            printWriter = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.println("<html><head><title>" + title + "</title></head><body>");
        printWriter.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeContent(String content) {
        printWriter.println("<p>" + content + "</p>");
    }

    @Override
    public void makeItems(List<String> items) {
        printWriter.println("<ul>");
        for (String item : items) {
            printWriter.println("<li>" + item + "</li>");
        }
        printWriter.println("</ul>");

    }

    @Override
    public void close() {
        printWriter.println("</body></html>");
        printWriter.close();
    }

    public String getResult() {
        return filename;
    }
}
