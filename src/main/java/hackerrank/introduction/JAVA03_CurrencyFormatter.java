package hackerrank.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JAVA03_CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        //인도는 Locale에 없어서 다른 통화로 변환 후 앞에 붙은 통화기호를 삭제함.
        System.out.println("India: Rs." + NumberFormat.getCurrencyInstance(Locale.ENGLISH).format(payment).substring(1));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }
}

