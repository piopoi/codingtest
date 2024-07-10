package algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 분할 정복 (Divide and Conquer)
 * - 분할 정복은 재귀로 구현하는 것이 일반적이다.
 * - 예시: 피보나치 수열, 합병 정렬
 * <p>
 * Divide: 큰 문제를 작은 문제로 분할.
 * - 기저 사례(base case)를 잘 설정하여 일정 기준 이상 분할되지 않도록 해야 한다.
 * Conquer: 작은 문제의 답을 모아, 큰 문제의 답을 구한다.
 */
public class DivideAndConquer {
    @Test
    @DisplayName("분할 정복")
    void test() {
        assertThat(fibonacciByRecursion(6)).isEqualTo(8);
        assertThat(fibonacciByDP(6)).isEqualTo(8);
    }

    /**
     * 피보나치 수열(Fibonacci sequence) {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, …}
     * - 재귀 (Recursion)
     *
     *  @param n = 피보나치 수열의 인덱스. 0부터 시작한다.
     */
    private int fibonacciByRecursion(int n) {
        if (n <= 1) { //2번 째까지 값은 1이다.
            return n;
        }
        return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
    }

    /**
     * 피보나치 수열(Fibonacci sequence)
     * - 동적 프로그래밍 (DP, Dynamic Programming)
     */
    private int fibonacciByDP(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        //dp[0] = 0; //int 기본값(=0)으로 자동 초기화
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
