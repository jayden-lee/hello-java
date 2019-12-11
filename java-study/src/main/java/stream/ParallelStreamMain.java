package stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelStreamMain {

    private static List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // parallel stream example
        settingParallelStream();
        parallelStreamWithCommonPoolExample();
        parallelStreamWithCustomPoolExample();

        // common parallel example
//        commonParallelExample();
    }

    private static void commonParallelExample() {
        System.out.println("Common Parallel Example");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < list.size(); i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + ", index=" + index + ", ended at " + LocalDateTime.now());
            });
        }
        executor.shutdown();
        System.out.println();
    }

    private static void settingParallelStream() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "6");
    }

    private static void parallelStreamWithCommonPoolExample() {
        System.out.println("Parallel Stream With Common Pool Example");
        list.parallelStream().forEach(index -> {
            System.out.println(Thread.currentThread().getName() + ", index=" + index + ", ended at " + LocalDateTime.now());
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
            } catch (InterruptedException e) {
            }
        });
        System.out.println();
    }

    private static void parallelStreamWithCustomPoolExample() throws ExecutionException, InterruptedException {
        System.out.println("Parallel Stream With Custom Pool Example");
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        forkJoinPool.submit(() -> list.parallelStream().forEach(index -> {
            System.out.println(Thread.currentThread().getName() + ", index=" + index + ", ended at " + LocalDateTime.now());
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
            } catch (InterruptedException e) {
            }
        })).get();
        forkJoinPool.shutdown();
        System.out.println();
    }
}
