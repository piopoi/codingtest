package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 패스트캠퍼스 - 컴퓨터 공학 전공 필수 올인원 패키지 강의 중에서
 * 나동빈 강사님의 C로 설명하는 알고리즘 코드를 Java로 바꿔봄.
 *
 *
 * 선택정렬
 *
 * 선택 정렬(選擇整列, selection sort)은 제자리 정렬 알고리즘의 하나로, 다음과 같은 순서로 이루어진다.
 *
 * 1. 주어진 리스트 중에 최소값을 찾는다.
 * 2. 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
 * 3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
 *
 * 비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는 Θ(n2) 만큼의 시간이 걸린다.
 * 선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있다.
 *
 * 출처 : 위키백과 https://ko.wikipedia.org/wiki/%EC%84%A0%ED%83%9D_%EC%A0%95%EB%A0%AC
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 9, 1, 3, 7, 2, 10, 4};
        System.out.println(Arrays.toString(arr));

        int min; //최소값
        int index; //최소값 위치

        for (int i = 0; i < arr.length; i++) {
            index = i;
            min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
//            Util.swap(arr, i, index);
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
            System.out.println(i + 1 + "회차: " + Arrays.toString(arr));
        }
    }
}
