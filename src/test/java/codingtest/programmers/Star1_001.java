package codingtest.programmers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * 문제 설명
 * 문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다.
 * str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
 * 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 * "l"이나 "r"이 없다면 빈 리스트를 return합니다.
 *
 * 제한사항
 * 1 ≤ str_list의 길이 ≤ 20
 * str_list는 "u", "d", "l", "r" 네 개의 문자열로 이루어져 있습니다.
 *
 * 입출력 예
 * str_list	-> result
 * ["u", "u", "l", "r"] -> ["u", "u"]
 * ["l"] -> []
 */
public class Star1_001 {
    @Test
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
