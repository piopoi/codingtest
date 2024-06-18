package quiz;

public class Quiz004 {

    /**
     * Q2. 문자열 'qwer'을 'rewq'로 거꾸로 출력하라
     */
    public static void main(String[] args) {
        String input = "qwer";
        String result = "";
        char[] c = input.toCharArray();

        System.out.printf("input = %s\n", input);

        for(int i = input.length() - 1; i >= 0 ; i--) {
            result += c[i];
        }

        System.out.printf("result = %s\n", result);
    }


}
