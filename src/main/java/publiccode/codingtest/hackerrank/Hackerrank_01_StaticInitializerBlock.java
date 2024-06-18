package publiccode.codingtest.hackerrank;

import java.util.Scanner;

public class Hackerrank_01_StaticInitializerBlock {
    public static void main(String[] args) {
        try {
            //input value
            Scanner scanner = new Scanner(System.in);
            int breadth = scanner.nextInt();
            int height = scanner.nextInt();
            scanner.close();

            //validate
            if (breadth < 1 || height < 1) {
                throw new Exception("Breadth and height must be positive");
            }

            //calculate
            int area = Math.multiplyExact(breadth, height);

            //print
            System.out.println(area);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
