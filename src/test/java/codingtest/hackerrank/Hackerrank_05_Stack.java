package codingtest.hackerrank;

import java.util.Stack;

/**
 * 해커랭크 문제풀이
 * https://www.hackerrank.com/challenges/java-stack/problem
 */
public class Hackerrank_05_Stack {
    public static void main(String[] argh) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String input = sc.next();
//            //Complete the code
//            System.out.println(checkString(input));
//        }

        System.out.println(checkString("{}()"));
        System.out.println(checkString("({()})"));
        System.out.println(checkString("{}("));
        System.out.println(checkString("[]"));
    }

    static boolean checkString(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()) return false;

            char popVal = stack.pop();
            if(c == '}' && popVal != '{') return false;
            if(c == ']' && popVal != '[') return false;
            if(c == ')' && popVal != '(') return false;
        }

        return stack.empty();
    }
}
