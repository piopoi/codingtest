package publiccode.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        long start, end;
        ThreadPoolTest1 threadPoolTest1 = new ThreadPoolTest1();

        //Multi Thread
        start = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newFixedThreadPool(1); //3091ms
//        ExecutorService executorService = Executors.newFixedThreadPool(2); //1631ms
//        ExecutorService executorService = Executors.newFixedThreadPool(3); //1315ms
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //828ms
        ExecutorService executorService = Executors.newFixedThreadPool(10); //672ms

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> threadPoolTest1.doSomething());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {}
        end = System.currentTimeMillis();
        System.out.println("Multi Thread(x10) = " + (end - start) + "ms");

        //Single Thread = 2931ms
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            threadPoolTest1.doSomething();
        }
        end = System.currentTimeMillis();
        System.out.println("Single Thread = " + (end - start) + "ms");
    }

    private void doSomething() {
        long n = 2;
        for (long j = 0; j < 1_000_000_000L; j++) {
            n *= 2;
        }
    }
}
