package etc;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnumCalculator2Test {

    //given
    private Double i = 1d;
    private Double j = 3d;

    @DisplayName("숫자 2개를 더할 수 있다.")
    @Test
    void plus() {
        //when
        Double result = EnumCalculator2.PLUS.operate(i, j);
        //then
        assertThat(result).isEqualTo(i + j);
    }

    @DisplayName("숫자 2개를 뺄 수 있다.")
    @Test
    void minus() {
        //when
        Double result = EnumCalculator2.MINUS.operate(i, j);
        //then
        assertThat(result).isEqualTo(i - j);
    }

    @DisplayName("숫자 2개를 곱할 수 있다.")
    @Test
    void multiply() {
        //when
        Double result = EnumCalculator2.MULTIPLY.operate(i, j);
        //then
        assertThat(result).isEqualTo(i * j);
    }

    @DisplayName("숫자 2개를 나눌 수 있다.")
    @Test
    void divide() {
        //when
        Double result = EnumCalculator2.DIVIDE.operate(i, j);
        //then
        assertThat(result).isEqualTo(i / j);
    }

}
