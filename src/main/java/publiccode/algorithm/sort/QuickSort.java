package publiccode.algorithm.sort;

import java.util.Arrays;

/**
 * 패스트캠퍼스 - 컴퓨터 공학 전공 필수 올인원 패키지 강의 중에서
 * 나동빈 강사님의 C로 설명하는 알고리즘 코드를 Java로 바꿔봄.
 *
 *
 * 퀵 정렬
 *
 * 퀵 정렬은 분할 정복(divide and conquer) 방법을 통해 리스트를 정렬한다.
 *
 * 1. 리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
 * 2. 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다. 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
 * 3. 분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.
 *
 * 재귀 호출이 한번 진행될 때마다 최소한 하나의 원소는 최종적으로 위치가 정해지므로, 이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.
 *
 * 출처 : 위키백과 https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC
 */
public class QuickSort {

    public static int n = 1; //회차

    public static void main(String[] args) {
        int[] arr = {8, 9, 0, 5, 3, 7, 6, 2, 1, 4};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivot = left;
        int i = left + 1; // arr[0]이 pivot이기 때문에 arr[1]이 left이다.
        int j = right;

        //분할 과정
        while (i <= j) { //엇갈릴 때까지 반복됨.
            System.out.println("\n" + n + "회차");

            while (i <= right && arr[i] <= arr[pivot]) //i는 pivot보다 큰 값을 찾으면 멈춘다.
                i++;
            while (j > left && arr[j] >= arr[pivot]) //j는 pivot보다 작은 값을 찾으면 멈춘다.
                j--;

            System.out.println(Arrays.toString(arr));
            System.out.println("array left index=" + left + ", right index=" + right);
            System.out.println("p=" + pivot + ", arr[p]=" + arr[pivot]);
            System.out.println("i=" + i + ", arr[i]=" + arr[i]);
            System.out.println("j=" + j + ", arr[j]=" + arr[j]);

            if (i > j) {
                System.out.println("i의 위치가 j보다 뒤에 있음.");
                System.out.println("SWAP: pivot(" + arr[pivot] + ") <-> j(" + arr[j] + ") & 분할");
                swap(arr, pivot, j);
            } else {
                System.out.println("SWAP: i(" + arr[i] + ") <-> j(" + arr[j] + ")");
                swap(arr, i, j);
            }

            System.out.println(Arrays.toString(arr));
            n++;
        }

        //정렬 과정
        quickSort(arr, left, j -1);
        quickSort(arr, j + 1, right);
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
