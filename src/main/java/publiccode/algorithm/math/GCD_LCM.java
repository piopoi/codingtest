package publiccode.algorithm.math;

/**
 * 최대공약수, 최소공배수 구하기
 *
 * 조건: 두 정수 a, b (a > b)
 */
public class GCD_LCM {

    public static void main(String[] args) {
        GCD_LCM g = new GCD_LCM();
        System.out.println("24과 16의 최대공약수 = " + g.gcd(24, 16)); //8
        System.out.println("24과 16의 최소공배수 = " + g.lcm(24, 16)); //48
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        int gcd = gcd(b, a);
        return a * b / gcd;
    }
}
