package publiccode.hackerrank;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = "java";
        String B = "hello";
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(toUpperCaseFirstChar(A) + " " + toUpperCaseFirstChar(B));
    }

    public static String toUpperCaseFirstChar(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
