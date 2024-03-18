package publiccode.practice.mutex;

public class SharedData {

    private int sharedValue = 0;
    private final Mutex mutex;

    public SharedData(Mutex mutex) {
        this.mutex = mutex;
    }

    public void sum() {
        try {
            mutex.acquired(); //lock 획득

            //임계 영역(critical section) - START
            for (int i = 0; i < 10000000; i++) {
                sharedValue++;
            }
            //임계 영역(critical section) - END
        } finally {
            mutex.release(); //lock 해제
        }
    }

    public int getSum() {
        return sharedValue;
    }
}
