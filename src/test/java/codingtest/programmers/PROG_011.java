package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 세로 읽기
 */
public class PROG_011 {

    @Test
    @DisplayName("세로 읽기")
    void test() {
        assertThat(solution("ihrhbakrfpndopljhygc", 4, 2))
                .isEqualTo("happy");
        assertThat(solution("programmers", 1, 1))
                .isEqualTo("programmers");
    }

    private String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();

        for(int i = c - 1; i < my_string.length(); i += m) {
            sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }
}
