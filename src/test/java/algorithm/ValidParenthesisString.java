package algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 올바른 괄호 문자열 (VPS = Valid Parenthesis String)
 *
 * 문제
 * - S라는 문자열이 입력될 때, S가 올바른 괄호 문자열인지 판단해라.
 * - 왼쪽 괄호와 오른쪽 괄호의 개수가 같은지 확인하는 문제.
 *
 * 힌트
 * - 빈 문자열은 올바른 괄호 문자열이다.
 * - S가 올바른 괄호 문자열이라면, (S)도 올바른 괄호 문자열이다.
 * - S, T가 괄호 문자뎔이라면, ST도 올바른 괄호 문자열이다.
 *
 * 해결
 * - 일반적으로 스택(Stack)을 사용한다.
 * - ')'가 입력될 때마다, 스택에 있는 '('를 하나씩 지운다.
 * - 이 때, 스택(top)이 비어있거나, '('가 없으면 올바른 괄호 문자열이 아니다.
 * - 모든 문자열을 순회한 뒤, 스택이 비어있으면 올바른 괄호 문자열이다.
 */
public class ValidParenthesisString {
    @Test
    @DisplayName("올바른 괄호 문자열(VPS) 판단")
    void test() {
        assertThat(isVPS("")).isTrue();
        assertThat(isVPS("()")).isTrue();
        assertThat(isVPS("(a)")).isTrue();
        assertThat(isVPS("(a())")).isTrue();
        assertThat(isVPS("(a))")).isFalse();
    }

    private boolean isVPS(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
