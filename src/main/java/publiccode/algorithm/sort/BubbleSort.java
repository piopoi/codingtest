package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 버블 정렬
 *
 * 직접 구현.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 9, 1, 3, 7, 2, 10, 4};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { //오름차순
//                if (arr[j] < arr[j + 1]) { //내림차순
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
