package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 접미사 배열
 *
 * 문제 설명
 * 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
 * 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
 * 문자열 my_string이 매개변수로 주어질 때,
 * my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string은 알파벳 소문자로만 이루어져 있습니다.
 * 1 ≤ my_string의 길이 ≤ 100
 *
 * 입출력 예
 * my_string	result
 * "banana"	["a", "ana", "anana", "banana", "na", "nana"]
 * "programmers"	["ammers", "ers", "grammers", "mers", "mmers", "ogrammers", "programmers", "rammers", "rogrammers", "rs", "s"]
 */
public class Star1_005 {

    @Test
    @DisplayName("접미사 배열")
    void test() {
        //1. Stream API
        assertThat(solution1("banana"))
                .isEqualTo(new String[]{"a", "ana", "anana", "banana", "na", "nana"});
        assertThat(solution1("programmers"))
                .isEqualTo(new String[]{"ammers", "ers", "grammers", "mers", "mmers", "ogrammers", "programmers", "rammers", "rogrammers", "rs", "s"});

        //2. 버블 정렬 직접 구현
        assertThat(solution2("banana"))
                .isEqualTo(new String[]{"a", "ana", "anana", "banana", "na", "nana"});
        assertThat(solution2("programmers"))
                .isEqualTo(new String[]{"ammers", "ers", "grammers", "mers", "mmers", "ogrammers", "programmers", "rammers", "rogrammers", "rs", "s"});

        //3. Arrays.sort
        assertThat(solution3("banana"))
                .isEqualTo(new String[]{"a", "ana", "anana", "banana", "na", "nana"});
        assertThat(solution3("programmers"))
                .isEqualTo(new String[]{"ammers", "ers", "grammers", "mers", "mmers", "ogrammers", "programmers", "rammers", "rogrammers", "rs", "s"});
    }

    public String[] solution1(String my_string) {
        return IntStream.range(0, my_string.length())
                .mapToObj(my_string::substring)
                .sorted()
                .toArray(String[]::new);
    }

    public String[] solution2(String my_string) {
        String[] arr = new String[my_string.length()];

        //접미사 추출
        for(int i = 0; i < my_string.length(); i++) {
            arr[i] = my_string.substring(i);
        }

        //정렬
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public String[] solution3(String my_string) {
        String[] arr = new String[my_string.length()];

        for(int i = 0; i < my_string.length(); i++) {
            arr[i] = my_string.substring(i);
        }

        Arrays.sort(arr);

        return arr;
    }
}
