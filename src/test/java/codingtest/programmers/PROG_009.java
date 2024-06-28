package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.lang.Math;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 주사위 게임 3
 */
public class PROG_009 {

    @Test
    @DisplayName("주사위 게임 3")
    void test() {
        assertThat(solution(2, 2, 2, 2)).isEqualTo(2222);
        assertThat(solution(4,1,4,4)).isEqualTo(1681);
        assertThat(solution(6,3,3,6)).isEqualTo(27);
        assertThat(solution(2,5,2,6)).isEqualTo(30);
        assertThat(solution(6,4,2,5)).isEqualTo(2);
    }

    private int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        if (arr[0] == arr[3]) {
            return 1111 * arr[0];
        }

        if (arr[0] == arr[2] || arr[1] == arr[3]) {
            int p = arr[0] == arr[2] ? arr[2] : arr[1];
            int q = arr[0] == arr[2] ? arr[3] : arr[0];
            return (10 * p + q) * (10 * p + q);
        }

        if (arr[0] == arr[1] && arr[2] == arr[3]) {
            return (arr[1] + arr[2]) * Math.abs(arr[1] - arr[2]);
        }

        if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[3]) {
            if (arr[0] == arr[1]) {
                return arr[2] * arr[3];
            } else if (arr[1] == arr[2]) {
                return arr[0] * arr[3];
            } else if (arr[2] == arr[3]) {
                return arr[0] * arr[1];
            }
        }

        return arr[0];
    }
}
