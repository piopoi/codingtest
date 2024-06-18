package publiccode.programming.sync_async.synchronized_;

/**
 * 멀티스레드에서 동기화 처리 없이 공유 자원에 대한 접근 테스트
 * 결과가 0이 되어야 하지만, 실제 테스트 시, 매 번 다른 결과가 나온다.
 */
public class Sync {
    private static int num = 0;

    public static void main(String[] args) {
        int count = 100000;

        Thread a = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                add();
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                subtract();
            }
        });

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("### num = " + num);
    }

    public static synchronized void add() {
        num = num + 1;
    }

    public static synchronized void subtract() {
        num = num - 1;
    }
}
