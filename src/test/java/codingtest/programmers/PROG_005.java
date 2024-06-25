package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 문자열이 몇 번 등장하는지 세기
 */
public class PROG_005 {
    @Test
    @DisplayName("")
    void test() {
        assertThat(solution("banana", "ana")).isEqualTo(2);
        assertThat(solution("aaaa", "aa")).isEqualTo(3);
    }

    private int solution(String myString, String pat) {
        int index = 0;
        int count = 0;

        while ((index = myString.indexOf(pat, index)) != -1) {
            count++;
            index++;
        }

        return count;
    }
}
