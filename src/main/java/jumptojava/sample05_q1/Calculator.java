package jumptojava.sample05_q1;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }

    boolean isOdd(int val) {
        return val % 2 == 1;
    }

    public int avg(int[] values) {
        return (int) Arrays.stream(values)
                .average()
                .orElse(-1)
                ;
    }

    public int avg(ArrayList<Integer> values) {
        return (int) values.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(-1)
                ;
    }

}
