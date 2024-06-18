package publiccode.java;

import java.util.function.BiFunction;

public class EnumCalculator {
    public static void main(String[] args) {
        Double a = 1d;
        Double b = 2d;
        Double result = Calculator.PLUS.operate(a, b);
        System.out.printf("%.2f + %.2f = %.2f", a, b, result);
    }

    public enum Calculator {
        PLUS("더하기", (i, j) -> i + j),
        MINUS("빼기", (i, j) -> i - j),
        MULTIPLY("곱하기", (i, j) -> i * j),
        DIVIDE("나누기", (i, j) -> i / j);

        private final String name;
        private final BiFunction<Double, Double, Double> biFunction;

        Calculator(String name, BiFunction<Double, Double, Double> biFunction) {
            this.name = name;
            this.biFunction = biFunction;
        }

        public Double operate(double a, double b) {
            return biFunction.apply(a, b);
        }
    }
}
