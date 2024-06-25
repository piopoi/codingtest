package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > ad 제거하기
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
