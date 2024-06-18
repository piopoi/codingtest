package quiz;

public class Quiz003 {

    /**
     * Q1. int 135를 String 변환 없이 531로 바꿔라.
     */
    public static void main(String[] args) {
        int input = 135;
        int result = 0;

        System.out.println("input = " + input);

        while (input > 0) {
            result *= 10;
            result += input % 10;
            input /= 10;
        }

        System.out.println("result = " + result);
    }

}
