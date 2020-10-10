package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + "World");

        System.out.println(completableFuture.get());
    }
}
