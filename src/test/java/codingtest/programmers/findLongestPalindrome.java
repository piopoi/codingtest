package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스
 * 가장 긴 팰린드롬 찾기
 */
public class findLongestPalindrome {
    @Test
    @DisplayName("가장 긴 팰린드롬 찾기")
    void test() {
        assertThat(solution("abcdcba")).isEqualTo(7);
        assertThat(solution("abaced")).isEqualTo(3);
    }

    private int solution(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;

        // 길이가 1인 모든 부분 문자열은 팰린드롬입니다.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 부분 문자열을 검사합니다.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // 길이가 3 이상인 부분 문자열을 검사합니다.
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }
}
