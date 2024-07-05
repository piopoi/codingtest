package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 문자 개수 세기
 */
public class PROG_013 {
    @Test
    @DisplayName("문자 개수 세기")
    void test() {
        assertThat(solution("Programmers"))
                .isEqualTo(
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2,
                                0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0});
    }

    private int[] solution(String my_string) {
        return Stream.concat(
                        IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char) c),
                        IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c)
                )
                .mapToInt(s -> {
                    int count = 0;
                    for (int i = 0; i < my_string.length(); i++) {
                        if (my_string.charAt(i) == s) {
                            count++;
                        }
                    }
                    return count;
                })
                .toArray();
    }
}
