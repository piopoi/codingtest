package publiccode.java.jumptojava.sample07_q3;

import java.util.ArrayList;

public class Sample07_q3 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            //HeavyWork w = new HeavyWork("w" + i);
            //w.work();
            Thread t = new Thread(new HeavyWork("w" + i));
            threads.add(t);

            //Thread의 run() vs start()
            //t.run(); //main Thread 1개로만 실행
            t.start(); //여러 Thread 사용
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.printf("elapsed time:%s ms\n", end - start);
    }
}



