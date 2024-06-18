package publiccode.java;

public class Stirng_StringBuffer_StringBuilder {
    public static void main(String[] args) {

        //StringBuffer
        long startAt = System.currentTimeMillis();
        StringBuffer b = new StringBuffer("init");
        for (int i = 0; i < 1000000; i++) {
            b.append("a");
        }
        long endAt = System.currentTimeMillis();
        System.out.println("StringBuffer 소요시간(ms) = " + (endAt - startAt));

        //StringBuilder
        startAt = System.currentTimeMillis();
        StringBuilder c = new StringBuilder("init");
        for (int i = 0; i < 1000000; i++) {
            c.append("a");
        }
        endAt = System.currentTimeMillis();
        System.out.println("StringBuilder 소요시간(ms) = " + (endAt - startAt));

        //String
        startAt = System.currentTimeMillis();
        String s = "init";
        for (int i = 0; i < 100000; i++) {
            s = s.concat("a");
        }
        endAt = System.currentTimeMillis();
        System.out.println("[번외] String 소요시간(ms) = " + (endAt - startAt));
    }
}
