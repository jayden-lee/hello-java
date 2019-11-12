package ch15_facade;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {

    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>" + title + "</h1>");
    }

    public void paragraph(String message) throws IOException {
        writer.write("<p>" + message + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href +"\">" + caption + "</a>");
    }

    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }

}
