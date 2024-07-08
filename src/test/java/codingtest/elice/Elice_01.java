package codingtest.elice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 주어진 수(number)와 같은 숫자 개수 및 숫자 구성이지만,
 * n보다 큰 정수 중에서 가장 작은 수 구하기
 */
class Elice_01 {
    @Test
    @DisplayName("")
    void test() {
        assertThat(solution(364)).isEqualTo(436);
        assertThat(solution(4142543)).isEqualTo(4143245);
        assertThat(solution(123754)).isEqualTo(124357);
    }

    private int solution(int number) {
        char[] arr = Integer.toString(number).toCharArray();

        int i = arr.length - 2;
        while (i > 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        swap(arr, i, j);

        Arrays.sort(arr, i + 1, arr.length);

        return Integer.parseInt(new String(arr));
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
