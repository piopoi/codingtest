package codingtest.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 > 코딩테스트 연습 > 완전탐색 > 모의고사
 */
public class PROG_008 {
    @Test
    @DisplayName("모의고사")
    void test() {
        assertThat(solution(new int[]{1,2,3,4,5}))
                .isEqualTo(new int[]{1});
        assertThat(solution(new int[]{1,3,2,4,2}))
                .isEqualTo(new int[]{1, 2, 3});
    }

    private int[] solution(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, getScore(answers, new int[]{1, 2, 3, 4, 5}));
        map.put(2, getScore(answers, new int[]{2, 1, 2, 3, 2, 4, 2, 5}));
        map.put(3, getScore(answers, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

        int maxValue = Collections.max(map.values());

        ArrayList<Integer> list = new ArrayList<>();
        for (int student : map.keySet()) {
            if (map.get(student) == maxValue) {
                list.add(student);
            }
        }

        return list.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }

    private int getScore(int[] answers, int[] solve) {
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == solve[i % solve.length]) {
                cnt++;
            }
        }
        return cnt;
    }
}
