package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > qr code
 */
public class PROG_012 {

    @Test
    @DisplayName("qr code")
    void test() {
        //solution 1
        assertThat(solution1(3, 1, "qjnwezgrpirldywt"))
                .isEqualTo("jerry");
        assertThat(solution1(1, 0, "programmers"))
                .isEqualTo("programmers");

        //solution 2
        assertThat(solution2(3, 1, "qjnwezgrpirldywt"))
                .isEqualTo("jerry");
        assertThat(solution2(1, 0, "programmers"))
                .isEqualTo("programmers");
    }

    private String solution1(int q, int r, String code) {
        return IntStream.range(0, code.length())
                .filter(i -> i % q == r)
                .mapToObj(i -> String.valueOf(code.charAt(i)))
                .collect(Collectors.joining());
    }

    private String solution2(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {
            sb.append(code.charAt(i));
        }
        return sb.toString();
    }
}
