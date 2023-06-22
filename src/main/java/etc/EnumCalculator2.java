package etc;

import java.util.function.BiFunction;

public enum EnumCalculator2 {
    PLUS("더하기", (i, j) -> i + j),
    MINUS("빼기", (i, j) -> i - j),
    MULTIPLY("곱하기", (i, j) -> i * j),
    DIVIDE("나누기", (i, j) -> i / j);

    private String name;
    private BiFunction<Double, Double, Double> biFunction;

    EnumCalculator2(String name, BiFunction<Double, Double, Double> biFunction) {
        this.name = name;
        this.biFunction = biFunction;
    }

    public Double operate(Double i, Double j) {
        return biFunction.apply(i, j);
    }

}
