package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 문제 설명
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 S가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 * 예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return 합니다.
 *
 * 제한사항
 * • 문자열 s의 길이 : 2,500 이하의 자연수
 * • 문자열 s는 알파벳 소문자로만 구성
 *
 * 입출력 예
 * String s -> answer
 * "abcdeba" -> 7
 * "abacde" -> 3
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
