package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class CollectionMain {

    public static void main(String[] args) {
        List<String> languageNames = List.of("java", "kotlin", "go", "javascript");

        // foreach
        System.out.println("# for each");
        languageNames.forEach(System.out::println);
        System.out.println();

        // spliterator
        System.out.println("# spliterator");
        Spliterator<String> spliterator1 = languageNames.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while(spliterator1.tryAdvance(System.out::println));
        System.out.println();
        while(spliterator2.tryAdvance(System.out::println));
        System.out.println();

        // comparator
        System.out.println("# comparator");
        List<String> copyLanguageNames = new ArrayList(languageNames);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        copyLanguageNames.sort(compareToIgnoreCase.reversed());
        System.out.println(copyLanguageNames);
    }
}
