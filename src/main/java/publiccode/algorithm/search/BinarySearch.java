package publiccode.algorithm.search;

import java.util.Arrays;

/**
 * 이진 탐색
 * <p>
 * 배열 내부 데이터가 이미 '정렬'되어 있는 상황에서 사용 가능한 알고리즘이다.
 * 탐색 범위를 절반 씩 좁혀가며 데이터를 탐색한다.
 * 탐색 속도가 빠르다
 */
public class BinarySearch {

    static int[] arr;

    public static void main(String[] args) {
        //데이터는 정렬이 되어있는 상태로 입력을 전제로 한다.
        arr = new int[]{1, 4, 24, 36, 74, 99, 105};
        System.out.println(Arrays.toString(arr));

        int result = binarySearch(0, arr.length-1, 24);

        if(result != -9999) {
            System.out.printf("해당 원소의 index = %d\n", result);
        } else {
            System.out.println("원소를 찾을 수 없습니다.");
        }
    }

    /**
     * 이진 탐색
     *
     * @param start  start index
     * @param end    end index
     * @param target target value
     * @return
     */
    static int binarySearch(int start, int end, int target) {
        if (start > end) return -9999; //wrong parameter

        int mid = (start + end) / 2; //mid index 찾기

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(start, mid - 1, target);
        } else { //arr[mid] < target
            return binarySearch(mid + 1, end, target);
        }
    }
}
