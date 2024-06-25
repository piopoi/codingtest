package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 2의 영역
 */
public class Star1_006 {
    @Test
    @DisplayName("")
    void test() {
        assertThat(solution1(new int[]{1, 2, 1, 4, 5, 2, 9}))
                .isEqualTo(new int[]{2, 1, 4, 5, 2});
        assertThat(solution1(new int[]{1, 2, 1}))
                .isEqualTo(new int[]{2});
        assertThat(solution1(new int[]{1, 1, 1}))
                .isEqualTo(new int[]{-1});
        assertThat(solution1(new int[]{1, 2, 1, 2, 1, 10, 2, 1}))
                .isEqualTo(new int[]{2, 1, 2, 1, 10, 2});
    }

    private int[] solution1(int[] arr) {
        int l = -1;
        int r = -1;

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                l = i;
                break;
            }
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                r = i;
                break;
            }
        }

        if (l == -1 || r == -1) {
            return new int[]{-1};
        }

//        int[] answer = new int[r - l + 1];
//        System.arraycopy(arr, l, answer, 0, r - l + 1);
//        return answer;
        return Arrays.copyOfRange(arr, l, r + 1);
    }
}
