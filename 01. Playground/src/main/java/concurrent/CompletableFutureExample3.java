package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Supplier<String> s1 = () -> {
            try {
                System.out.println("Start s1");
                Thread.sleep(2000L);
                System.out.println("Done s1");
                return "s1";
            } catch (InterruptedException e) {
                return null;
            }
        };

        Supplier<String> s2 = () -> {
            try {
                System.out.println("Start s2");
                Thread.sleep(150L);
                System.out.println("Done s2");
                return "s2";
            } catch (InterruptedException e) {
                return null;
            }
        };

        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(s1)
                .thenCombineAsync(CompletableFuture.supplyAsync(s2), (result1, result2) -> result1 + result2);

        System.out.println(completableFuture.get());
    }
}
