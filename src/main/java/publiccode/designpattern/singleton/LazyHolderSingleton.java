package publiccode.designpattern.singleton;

public class LazyHolderSingleton {

    private LazyHolderSingleton() {
    }

    private static class LazyHolder {
        private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
    }

    public static LazyHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}

class test {
    public static void main(String[] args) {
        LazyHolderSingleton instance = LazyHolderSingleton.getInstance();
        System.out.println("instance = " + instance);
    }
}
