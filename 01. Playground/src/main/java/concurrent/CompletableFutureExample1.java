package concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample1 {

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture1 = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Start completableFuture1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Done completableFuture1");
                    return "completableFuture1";
                });

        CompletableFuture<String> completableFuture2 = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Start completableFuture2");
                    try {
                        Thread.sleep(1500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Done completableFuture2");
                    return "completableFuture2";
                });

        CompletableFuture<String> completableFuture3 = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Start completableFuture3");
                    int i = 0;
                    try {
                        Thread.sleep(3500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i == 0) {
                        throw new RuntimeException();
                    }

                    System.out.println("Done completableFuture3");
                    return "completableFuture3";
                }).handle((s, t) -> {
                    System.err.printf("Error completableFuture3: %s\n", t.getMessage());
                    return s;
                });

        List<String> results = Stream.of(completableFuture1, completableFuture2, completableFuture3)
                .map(CompletableFuture::join)
                .filter(s -> s != null && !s.isBlank())
                .collect(Collectors.toList());

        System.out.println(results); // [completableFuture1, completableFuture2]
    }
}
