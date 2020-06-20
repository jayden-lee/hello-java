package ch08_abstract_factory;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }

        Factory factory = Factory.getFactory(args[0]);

        Link naverLink = factory.createLink("네이버", "https://www.naver.com");
        Link daumLink = factory.createLink("다음", "https://www.naver.com");

        Tray portalTray = factory.createTray("포탈");
        portalTray.add(naverLink);
        portalTray.add(daumLink);


        Link lelecoderLink = factory.createLink("lelecoder", "https://lelecoder.com");
        Link githubLink = factory.createLink("github", "https://github.com");
        Tray devTray = factory.createTray("기술");
        devTray.add(lelecoderLink);
        devTray.add(githubLink);

        Page page = factory.createPage("LinkPage", "페이지");
        page.add(portalTray);
        page.add(devTray);

        page.output();
    }
}
