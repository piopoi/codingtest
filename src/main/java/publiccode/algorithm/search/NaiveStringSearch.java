package publiccode.algorithm.search;

import java.util.Scanner;

/**
 * 단순 비교 문자열 검색 (Naive String Search)
 * <p>
 * 우직한 문자열 검색법. 이름 그대로다.
 * 1번째부터 m번째 글자까지, 2번째부터 m+1번째 글자까지, 이런 식으로 문자열을 일일이 찾아가면서 탐색한다.
 * 이 경우 길이가 각각 n, m인 문자열과 패턴에 대하여 O((n-m)m)의 시간 복잡도를 가진다.
 * 작동 시간이 오래 걸리지만 구현이 편하기 때문에, 충분히 작은 입력이라면 이런 알고리즘을 사용하는 것도 나쁘지 않다
 * <p>
 * 출처 : 나무위키 (https://namu.wiki/w/%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-2.1)
 */
public class NaiveStringSearch {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        String keyword = s.nextLine();
        s.close();

        search(text, keyword);
    }

    /**
     * 단순 비교 검색
     *
     * @param text  원본 문자열
     * @param keyword 찾을 문자열
     */
    public static void search(String text, String keyword) {
        int n = text.length();
        int m = keyword.length();

        for (int i = 0; i < n - m; i++) {
            boolean result = false; //같은 문자열 찾았는지 여부
            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) == keyword.charAt(j)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                System.out.printf("index[%d]에 있습니다.\n", i);
            }
        }
    }
}
