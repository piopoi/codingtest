package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 코딩 기초 트레이닝 > 배열 만들기 5
 */
public class PROG_010 {

    @Test
    @DisplayName("배열 만들기 5")
    void test() {
        assertThat(solution(
                new String[]{"0123456789", "9876543210", "9999999999999"},
                50000,
                5,
                5
        )).isEqualTo(new int[]{56789, 99999});
    }

    private int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if(k < num) {
                list.add(num);
            }
        }

        //return list.stream().mapToInt(i -> i).toArray(); //느리다..
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
