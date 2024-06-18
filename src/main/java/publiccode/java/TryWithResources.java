package publiccode.java;

public class TryWithResources {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            resource.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Resource implements AutoCloseable {

    public void doSomething() {
        System.out.println("call: MyResource.doSomething()");
    }

    @Override
    public void close() throws Exception {
        System.out.println("call: MyResource.close()");
    }
}
