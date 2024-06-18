package publiccode.programming.sync_async.mutex;

public class Mutex {

    private boolean lock = false;

    public synchronized void acquired() {
        while (lock) { //다른 스레드에서 lock을 먼저 가진 경우 lock이 true라 while문을 수행한다.
            try {
                wait(); //스레드를 대기 상태로 변경한다.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        lock = true; //lock 획득 시 true로 변경.
    }

    public synchronized void release() {
        lock = false; //lock 해제
        notify(); //대기 중인 스레드를 깨운다.
    }
}
