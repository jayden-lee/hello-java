package ch11_composite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");

        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);

        bindir.add(new File("vi", 1000));
        bindir.add(new File("latex", 20000));
        rootdir.printList();

        System.out.println();
        System.out.println("Making user entries");
        Directory jaydendir = new Directory("jayden");
        Directory elladir = new Directory("ella");
        Directory ckadir = new Directory("cka");

        usrdir.add(jaydendir);
        usrdir.add(elladir);
        usrdir.add(ckadir);

        jaydendir.add(new File("index.html", 1000));
        jaydendir.add(new File("Composite.java", 12000));
        elladir.add(new File("memo.txt", 3000));
        ckadir.add(new File("memo.doc", 4000));
        ckadir.add(new File("a.js", 1000));

        rootdir.printList();
    }
}
