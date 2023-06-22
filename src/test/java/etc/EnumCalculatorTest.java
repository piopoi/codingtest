package etc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnumCalculatorTest {

    //given
    int a = 5, b = 2;

    @DisplayName("숫자를 더할 수 있다.")
    @Test
    void plus() {
        //when
        double result = EnumCalculator.PLUS.calculate(a, b);
        //then
        assertThat(result).isEqualTo(7);
    }

    @DisplayName("숫자를 뺄 수 있다.")
    @Test
    void minus() {
        //when
        double result = EnumCalculator.MINUS.calculate(a, b);
        //then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("숫자를 곱할 수 있다.")
    @Test
    void multiply() {
        //when
        double result = EnumCalculator.MULTIPLY.calculate(a, b);
        //then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("숫자를 나눌 수 있다.")
    @Test
    void divide() {
        //when
        double result = EnumCalculator.DIVIDE.calculate(a, b);
        //then
        assertThat(result).isEqualTo(2.5);
    }
}
