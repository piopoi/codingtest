package codingtest.programmers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 왼쪽 오른쪽
 */
public class PROG_002 {
    @Test
    @DisplayName("왼쪽 오른쪽")
    void test() {
        assertThat(solution(new String[]{"u", "u", "l", "r"}))
                .isEqualTo(new String[]{"u", "u"});
        assertThat(solution(new String[]{"u", "u"}))
                .isEqualTo(new String[]{});
        assertThat(solution(new String[]{"l", "u"}))
                .isEqualTo(new String[]{});
        assertThat(solution(new String[]{"r", "u"}))
                .isEqualTo(new String[]{"u"});
    }

    private String[] solution(String[] str_list) {
        for(int i = 0; i < str_list.length; i++) {
            if(str_list[i].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, i);
            }
            if(str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }
        return new String[0];
    }

    private int indexOf(String[] arr, String target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
