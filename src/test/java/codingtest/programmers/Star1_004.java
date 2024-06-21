package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 문자열이 몇 번 등장하는지 세기
 *
 * 문제 설명
 * 문자열 myString과 pat이 주어집니다. myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ myString ≤ 1000
 * 1 ≤ pat ≤ 10
 *
 * 입출력 예
 * myString	pat	result
 * "banana"	"ana"	2
 * "aaaa"	"aa"	3
 */
public class Star1_004 {
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
