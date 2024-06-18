package publiccode.algorithm.search;

import java.util.Arrays;

/**
 * KMP 문자열 검색
 */
public class KMPStringSearch {

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String text = s.nextLine();
//        String keyword = s.nextLine();
//        s.close();
        String text = "acabacdabac";
        String keyword = "abacdab";

        KMP(text, keyword);
    }

    public static void KMP(String text, String keyword) {
        System.out.println("text = " + text);
        System.out.println("keyword = " + keyword);

        int[] table = makeTable(keyword);
        System.out.println("table = " + Arrays.toString(table));

        int textSize = text.length();
        int keywordSize = keyword.length();

        int j = 0;
        for(int i = 0; i < textSize; i++) {
            while(j > 0 && text.charAt(i) != keyword.charAt(j)) {
                j = table[j - 1];
            }
            if(text.charAt(i) == keyword.charAt(j)){
                if(j == keywordSize - 1) {
                    System.out.printf("index[%d]에서 매칭 성공\n", i - keywordSize + 1);
                    System.out.printf("i=%d / j=%d / keywordSize=%d\n", i, j, keywordSize);
                    j = table[j]; //뒤로 돌아가서 다시 검사해야하는데, 이미 일치했던 부분은 넘어감.
                } else {
                    j++;
                }
            }
        }
    }

    public static int[] makeTable(String keyword) {
        int keywordSize = keyword.length();
        int[] table = new int[keywordSize];

        int j = 0;
        for (int i = 1; i < keywordSize; i++) {
            while (j > 0 && keyword.charAt(i) != keyword.charAt(j)) {
                j = table[j - 1];
            }
            if (keyword.charAt(j) == keyword.charAt(i)) {
                table[i] = ++j;
            }
        }

        return table;
    }

}
