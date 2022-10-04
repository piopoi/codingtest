package hackerrank.advanced;

import java.security.MessageDigest;
import java.util.Scanner;

public class JAVA04_SHA256 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());

            System.out.println(bytesToHex(md.digest()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
