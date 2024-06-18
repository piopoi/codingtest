package publiccode.algorithm.search;

/**
 * 라빈 카프(Rabin-Karp) 문자열 탐색 알고리즘
 * <p>
 * 해싱(Hashing)을 사용해서 문자열에서 특정 패턴과 일치하는지 찾아주는 알고리즘.
 */
public class RabinKarpStringSearch {

    public static void main(String[] args) {
        String text = "acabacdabacabacsdf";
        String pattern = "abac";

        rabinKarp(text, pattern);
    }

    public static void rabinKarp(String text, String pattern) {
        int textHash = 0;
        int patternHash = 0;
        int power = 1;

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            //0번째 탐색
            if (i == 0) {
                for (int j = 0; j < pattern.length(); j++) {
                    //pattern 해시값 구하기
                    patternHash += pattern.charAt(pattern.length() - j - 1) * power;
                    //0번째 해시값 구하기
                    textHash += text.charAt(pattern.length() - j - 1) * power;
                    //제곱 수 계산
                    if(j < pattern.length() - 1) power *= 2;
                }
            }
            //1~번째 탐색
            else {
                //다음 해시 값 = 2 * (현재 해시 값 - 가장 앞에 있는 문자의 수치) + 새 문자의 수치
                int firstVal = text.charAt(i - 1) * power; //가장 앞에 있는 문자의 수치
                textHash = 2 * (textHash - firstVal) + text.charAt(pattern.length() - 1 + i);
            }

            //두 해시값이 같다면
            if (patternHash == textHash) {
                check(text, pattern, i);
            }
        }
    }

    /**
     * Hashing
     */
    public static int hashing(String txt) {
        int result = 0;
        char[] arr = txt.toCharArray();

        //Hash Function = 각 문자의 아스키코드 값 * 2^index
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(i - arr.length - 1);
            result += arr[idx] * Math.pow(2, idx);
        }

        return result;
    }

    /**
     * 해시 값이 같은 경우, 해시 충돌을 대비하여 다시 한 번 체크하는 함수
     *
     * @param text    원본 문자열
     * @param pattern 검색어
     * @param start   시작 인덱스
     */
    public static void check(String text, String pattern, int start) {
        boolean res = true;
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                res = false;
                break;
            }
        }
        if (res) {
            System.out.printf("인덱스[%d]에서 매칭 발생\n", start);
        } else {
            //해시 충돌이 발생한 경우에만 아래 문구 출력됨.
            System.out.println("일치하는 인덱스가 없습니다.");
        }
    }
}
