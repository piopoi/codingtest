package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 패스트캠퍼스 - 컴퓨터 공학 전공 필수 올인원 패키지 강의 중에서 나동빈 강사님의 C로 설명하는 알고리즘 코드를 Java로 바꿔봄.
 * <p>
 * <p>
 * 계수 정렬
 * <p>
 * 크기를 기준으로 데이터의 개수를 세는 정렬 알고리즘. 각 데이터를 바로 크기를 기준으로 분류하므로 O(N)의 시간 복잡도를 가진다. 배열의 최대 인덱스 이상의 수는 정렬하지 못한다.
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 5, 2, 4, 5, 1, 1, 4, 3, 5};
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr.length = " + arr.length + "\n");
        countingSorting(arr, 5);
    }

    public static void countingSorting(int[] input, int inputMaxValue) {
        //count: 정렬하고자 하는 배열의 길이가 아닌, 값을 기준으로 배열 크기를 지정하기 때문에 메모리 낭비가 심하다.
        int[] count = new int[inputMaxValue + 1];

        //output: 정렬 완료된 배열
        int[] output = new int[input.length];

        System.out.println("Step1. 계수 구하기(Counting)");
        for (int i = 0; i < input.length; i++) {
            count[input[i]]++;
        }
        System.out.println("input = " + Arrays.toString(input));
        System.out.println("count = " + Arrays.toString(count));
        System.out.println("output = " + Arrays.toString(output) + "\n");

        System.out.println("Step2. 전위합 구하기");
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println("input = " + Arrays.toString(input));
        System.out.println("count = " + Arrays.toString(count));
        System.out.println("output = " + Arrays.toString(output) + "\n");

        System.out.println("Step3. 전위합을 이용하여 값들을 배치");
        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i];
            count[val] = count[val] - 1;
            output[count[val]] = input[i];
        }

        System.out.println("input = " + Arrays.toString(input));
        System.out.println("count = " + Arrays.toString(count));
        System.out.println("output = " + Arrays.toString(output));
    }
}
