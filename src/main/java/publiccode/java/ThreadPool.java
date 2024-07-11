package publiccode.java;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 10개의 스레드 풀(Thread Pool)을 생성하여 100개의 작업을 수행한다.
 */
public class ThreadPool {

    private static int taskId = 0;

    public static void main(String[] args) {
        long start, end;
        Runnable task = new PowTask();

        // Multi Thread: FixedThreadPool
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(task);
        }
        end = System.currentTimeMillis();
        System.out.println("Multi Thread: FixedThreadPool = " + (end - start) + "ms");

        // Single Thread
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            task.run();
        }
        end = System.currentTimeMillis();
        System.out.println("Single Thread = " + (end - start) + "ms");

        //3. 스레드 풀 종료
        executorService.shutdown();
    }

    private static class PowTask implements Runnable {
        @Override
        public void run() {
            // 2의 1,000,000 제곱 계산
            int n = 2;
            for (int j = 0; j < 1_000_000; j++) {
                n *= 2;
            }
        }
    }
}
