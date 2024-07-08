package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 글자 지우기
 */
public class PROG_014 {
    @Test
    @DisplayName("글자 지우기")
    void test() {
        assertThat(solution1("apporoograpemmemprs", new int[]{1, 16, 6, 15, 0, 10, 11, 3}))
                .isEqualTo("programmers");
        assertThat(solution2("apporoograpemmemprs", new int[]{1, 16, 6, 15, 0, 10, 11, 3}))
                .isEqualTo("programmers");
    }

    private String solution1(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();

        outerLoop:
        for (int i = 0; i < my_string.length(); i++) {
            for (int j = 0; j < indices.length; j++) {
                if (i == indices[j]) {
                    continue outerLoop;
                }
            }
            sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }

    private String solution2(String my_string, int[] indices) {
        String[] arr = my_string.split("");
        for(int i = 0; i < indices.length; i++) {
            arr[indices[i]] = "";
        }
        return String.join("", arr);
    }
}
