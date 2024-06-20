package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ad 제거하기
 *
 * 문제 설명
 * 문자열 배열 strArr가 주어집니다.
 * 배열 내의 문자열 중 "ad"라는 부분 문자열을 포함하고 있는 모든 문자열을 제거하고
 * 남은 문자열을 순서를 유지하여 배열로 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ strArr의 길이 ≤ 1,000
 * 1 ≤ strArr의 원소의 길이 ≤ 20
 * strArr의 원소는 알파벳 소문자로 이루어진 문자열입니다.
 *
 * 입출력 예
 * strArr	result
 * ["and","notad","abcd"]	["and","abcd"]
 * ["there","are","no","a","ds"]	["there","are","no","a","ds"]
 */
public class Star1_002 {
    @Test
    @DisplayName("ad 제거하기")
    void test() {
        assertThat(solution(new String[]{"and","notad","abcd"}))
                .isEqualTo(new String[]{"and","abcd"});
        assertThat(solution(new String[]{"there","are","no","a","ds"}))
                .isEqualTo(new String[]{"there","are","no","a","ds"});
    }

    public String[] solution(String[] strArr) {
        return Stream.of(strArr)
                .filter(s -> !s.contains("ad"))
                .toArray(String[]::new);
    }
}
