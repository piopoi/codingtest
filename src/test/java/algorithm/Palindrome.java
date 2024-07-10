package algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 회문 (Palindrome)
 * https://ko.wikipedia.org/wiki/%ED%9A%8C%EB%AC%B8
 * <p>
 * 예시
 * - 12321
 * - level
 */
public class Palindrome {
    @Test
    @DisplayName("회문(Palindrome) 찾기")
    void test() {
        assertThat(isPalindrome("level")).isTrue();
        assertThat(isPalindrome("levvel")).isTrue();
        assertThat(isPalindrome("lvveel")).isFalse();
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
