package ch15_facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Database 클래스와 HtmlWriter 클래스를 이용해서 사용자의 웹 페이지를 작성하는
 * 클래스. PageMaker 클래스는 외부로 makeWelcomePage 메서드 하나만 공개하고, 클
 * 라이언트는 공개된 API를 통해서만 웹 페이지를 쉽게 작성할 수 있다.
 */
public class PageMaker {

    private PageMaker() {

    }

    public static void makewelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "`s page!");
            writer.paragraph(username + "의 페이지에 오신 걸 환영합니다.");
            writer.paragraph("메일을 기다리고 있습니다.");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
