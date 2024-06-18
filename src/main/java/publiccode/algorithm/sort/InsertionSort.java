package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 패스트캠퍼스 - 컴퓨터 공학 전공 필수 올인원 패키지 강의 중에서
 * 나동빈 강사님의 C로 설명하는 알고리즘 코드를 Java로 바꿔봄.
 *
 *
 * 삽입정렬
 *
 * 삽입 정렬(揷入整列, insertion sort)은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
 * 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다.
 * k번째 반복 후의 결과 배열은, 앞쪽 k + 1 항목이 정렬된 상태이다.
 * 각 반복에서 정렬되지 않은 나머지 부분 중 첫 번째 항목은 제거되어 정확한 위치에 삽입된다. 그러므로 다음과 같은 결과가 된다.
 * 배열이 길어질수록 효율이 떨어진다. 다만, 구현이 간단하다는 장점이 있다.
 * 선택 정렬이나 거품 정렬과 같은 같은 O(n2) 알고리즘에 비교하여 빠르며, 안정 정렬이고 in-place 알고리즘이다.
 *
 * 출처 : 위키백과 https://ko.wikipedia.org/wiki/%EC%82%BD%EC%9E%85_%EC%A0%95%EB%A0%AC
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 9, 1, 3, 7, 2, 10, 4};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while (j >= 0 && arr[j] > arr[j + 1]) {
//                Util.swap(arr, j, j+1);
                //swap
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;

                j--;
            }

            System.out.println(i + 1 + "회차: " + Arrays.toString(arr));
        }
    }
}
