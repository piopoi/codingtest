package publiccode.designpattern.singleton;

/**
 * DCL(Double-checked locking)
 */
public class DCLSingleton {

    private volatile static DCLSingleton instance;

    private DCLSingleton() {
    }

    public DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
