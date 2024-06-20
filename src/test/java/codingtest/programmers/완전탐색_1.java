package codingtest.programmers;

import java.util.*;

/*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2,
*/
public class 완전탐색_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, confirm(answers, new int[]{1, 2, 3, 4, 5}));
        map.put(2, confirm(answers, new int[]{2, 1, 2, 3, 2, 4, 2, 5}));
        map.put(3, confirm(answers, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

        int maxValue = Collections.max(map.values());

        ArrayList<Integer> list = new ArrayList<>();
        for (int student : map.keySet()) {
            if (map.get(student) == maxValue) {
                list.add(student);
            }
        }

        return list.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i.intValue())
                .toArray()
                ;
    }

    public static int confirm(int[] answers, int[] solve) {
        int cnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == solve[i % solve.length]) {
                cnt++;
            }
        }

        return cnt;
    }

}
