package etc;

import java.util.function.BiFunction;

public enum EnumCalculator {
    PLUS("더하기", (i, j) -> i + j),
    MINUS("빼기", (i, j) -> i - j),
    MULTIPLY("곱하기", (i, j) -> i * j),
    DIVIDE("나누기", (i, j) -> i / j);

    private final String name;
    private final BiFunction<Double, Double, Double> biFunction;

    EnumCalculator(String name, BiFunction<Double, Double, Double> biFunction) {
        this.name = name;
        this.biFunction = biFunction;
    }

    public Double calculate(double a, double b) {
        return biFunction.apply(a, b);
    }

}
