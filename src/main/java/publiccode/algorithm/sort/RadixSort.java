package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 패스트캠퍼스 - 컴퓨터 공학 전공 필수 올인원 패키지 강의 중에서 나동빈 강사님의 C로 설명하는 알고리즘 코드를 Java로 바꿔봄.
 * <p>
 * <p>
 * <p>
 * 기수 정렬
 * <p>
 * 기수에 따라 원소를 버킷에 집어 넣기 때문에 비교 연산이 불필요하다. 유효숫자가 두 개 이상인 경우 모든 숫자 요소에 대해 수행될 때까지 각 자릿수에 대해 반복한다. 따라서 전체 시간 복잡도는 O(nw)(w는 기수의 크기)이 된다. 정수와 같은 자료의 정렬 속도가
 * 매우 빠르다. 하지만, 데이터 전체 크기에 기수 테이블의 크기만한 메모리가 더 필요하다.
 * <p>
 * 기수 정렬은 정렬 방법의 특수성 때문에, 부동소수점 실수처럼 특수한 비교 연산이 필요한 데이터에는 적용할 수 없지만, 사용 가능할 때에는 매우 좋은 알고리즘이다.
 * <p>
 * 계수정렬에 비해 약간 더 느리지만, 숫자가 매우 큰 상황에서도 사용할 수 있다.
 * <p>
 * 출처 : 위키백과 https://ko.wikipedia.org/wiki/%EA%B8%B0%EC%88%98_%EC%A0%95%EB%A0%AC
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] input = {51, 802, 6, 91, 100, 38, 7, 27, 101, 409};
        System.out.println(Arrays.toString(input));
        System.out.println();

        radixSort(input);
        System.out.println("result: " + Arrays.toString(input));
    }

    public static void radixSort(int[] input) {
        int maxValue = 0;
        int exp = 1; //자릿수

        //입력받은 배열의 최대값 찾기
        for (int i = 0; i < input.length; i++) {
            if (input[i] > maxValue) {
                maxValue = input[i];
            }
        }

        while (maxValue / exp > 0) { //가장 큰 자릿수 까지만 계산되도록 조건 설정
            System.out.println(exp + "의 자릿수 기준 정렬");
            int[] bucket = new int[10];
            int[] temp = new int[input.length];

            //step1: 자릿수 배열 처리
            System.out.println("STEP1: 자릿수 배열 처리");
            for (int i = 0; i < input.length; i++) {
                int n = input[i] / exp % 10; //exp 자리의 값 구하기
                bucket[n]++;
                System.out.println("STEP1: bucket=" + Arrays.toString(bucket));
            }

            //step2: 누적합 계산
            System.out.println("STEP2: 누적합 계산");
            //i가 1부터인 이유는 첫번째 자리는 값을 더할 bucket[-1]이란게 없기 때문
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
                System.out.println("STEP2: bucket=" + Arrays.toString(bucket));
            }

            //step3: 임시 배열에 정렬
            //계수 정렬(counting sort) 방식: 누적합을 사용해 각 항목의 위치를 결정한다.
            System.out.println("STEP3: 임시 배열에 정렬");
            for (int i = input.length - 1; i >= 0; i--) { //뒤에서부터 정렬
                int n = input[i] / exp % 10; //exp 자리의 값 구하기
                temp[--bucket[n]] = input[i];
                System.out.println("STEP3: output=" + Arrays.toString(temp));
            }

            //기본 배열 갱신(배열 복사)
            for (int i = 0; i < input.length; i++) {
                input[i] = temp[i];
            }
            exp *= 10; //자리수 높이기
            System.out.println();
        }
    }
}
