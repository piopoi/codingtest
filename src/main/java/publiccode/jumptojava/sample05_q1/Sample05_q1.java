package publiccode.jumptojava.sample05_q1;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample05_q1 {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        cal1.add(10);
        System.out.println(cal1.getValue());
        System.out.println();

        UpgradeCalculator cal2 = new UpgradeCalculator();
        cal2.add(10);
        cal2.minus(3);
        System.out.println(cal2.getValue());  // 10에서 3을 뺀 7을 출력
        System.out.println();

        MaxLimitCalculator cal3 = new MaxLimitCalculator();
        cal3.add(50);  // 50 더하기
        cal3.add(60);  // 60 더하기
        System.out.println(cal3.getValue());  // 100 출력
        System.out.println();

        Calculator cal4 = new Calculator();
        System.out.println(cal4.isOdd(3));  // 3은 홀수이므로 true 출력
        System.out.println(cal4.isOdd(4));  // 4는 짝수이므로 false 출력
        System.out.println();

        int[] data = {1, 3, 5, 7, 9};
        Calculator cal5 = new Calculator();
        int result = cal5.avg(data);
        System.out.println(result);  // 5 출력
        System.out.println();

        ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        Calculator cal6 = new Calculator();
        int result2 = cal6.avg(data2);
        System.out.println(result2);  // 5 출력
        System.out.println();
    }
}
