package publiccode.java.jumptojava.sample07_q3;

public class HeavyWork implements Runnable {
    String name;

    HeavyWork(String name) {
        this.name = name;
    }

    public void work() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);  // 0.1 초 대기한다.
            } catch (Exception e) {
            }
        }
        System.out.printf("%s done : %s\n", this.name, Thread.currentThread().getName());
    }

    @Override
    public void run() {
        work();
    }
}
