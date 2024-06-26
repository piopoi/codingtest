package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 1로 만들기
 */
public class PROG_004 {
    @Test
    @DisplayName("1로 만들기")
    void test() {
        assertThat(solution1(new int[]{12, 4, 15, 1, 14})).isEqualTo(11);
        assertThat(solution2(new int[]{12, 4, 15, 1, 14})).isEqualTo(11);
    }

    private int solution1(int[] num_list) {
        return Arrays.stream(num_list)
                .map(n -> Integer.toBinaryString(n).length() - 1)
                .sum();
        /**
         * 이진수를 2로 나누는 연산은 이진수의 가장 오른쪽 한 자리가 0일때 이 자리를 삭제하는 것과 같음.
         *  12(1100) / 2 = 6(110)
         *  6(110) / 2 = 3(11)
         *  (3(11) - 1) / 2 = 1(1) //홀수라서 -1
         *
         * by ChatGPT 4o
         *  1.	Arrays.stream(num_list):
         * 	    •	num_list 배열을 스트림으로 변환합니다. 스트림은 배열 또는 컬렉션에 저장된 요소들을 순차적으로 처리할 수 있는 유틸리티입니다.
         * 	2.	.map(i -> Integer.toBinaryString(i).length() - 1):
         * 	    •	스트림의 각 요소 i에 대해 다음 변환을 수행합니다:
         * 	    •	Integer.toBinaryString(i)는 정수 i를 이진 문자열로 변환합니다.
         * 	    •	Integer.toBinaryString(i).length()는 이진 문자열의 길이를 구합니다.
         * 	    •	Integer.toBinaryString(i).length() - 1은 이진 문자열의 길이에서 1을 뺀 값을 구합니다.
         * 	3.	.sum():
         * 	    •	변환된 모든 값들을 합산합니다.
         */
    }


    private int solution2(int[] num_list) {
        int count = 0;
        for(int num : num_list) {
            count += getOperateCount(num);
        }
        return count;
    }

    private int getOperateCount(int num) {
        int count = 0;
        while (num != 1) {
            if(num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num - 1) / 2;
            }
            count++;
        }
        return count;
    }
}
