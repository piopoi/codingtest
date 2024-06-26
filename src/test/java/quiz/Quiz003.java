package quiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * int 135를 String 변환 없이 531로 바꿔라.
 */
public class Quiz003 {

    @Test
    @DisplayName("")
    void test() {
        assertThat(solution1(135)).isEqualTo(531);
    }

    private int solution1(int input) {
        int result = 0;
        while (input > 0) {
            result *= 10;
            result += input % 10;
            input /= 10;
        }
        return result;
    }
}
