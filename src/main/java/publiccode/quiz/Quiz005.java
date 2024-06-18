package publiccode.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 모든 원소가 0 또는 1인 행렬이 있습니다.
 * 1로 표시된 원소는 영역을 나타냅니다.
 * 여기에서 상하좌우에 인접한 1은 같은 영역이라고 가정합니다.
 * 각 영역의 크기는 1의 개수로 정의합니다.
 * 주어진 N x N 크기의 행렬에서 영역의 개수와 각 영역의 크기를 오름차순으로 출력하세요.
 * <p>
 * Flood Fill Algorithm 문제.
 * 최단 경로를 찾을 필요 없이, 연결된 공간이 몇 개인지 알아야 할 때 활용한다.
 * 데이터 크기가 크지 않은 경우, 단순한 DFS 만으로도 문제를 풀 수 있다.
 */
public class Quiz005 {
    static int cnt = 0;
    static int n = 0; //배열크기 n x n
    static int[][] arr;


    public static void main(String[] args) {
        n = 6;
        arr = new int[n][n];

        arr[0] = new int[]{1, 0, 1, 1, 0, 0};
        arr[1] = new int[]{1, 1, 0, 0, 1, 1};
        arr[2] = new int[]{0, 0, 1, 1, 0, 1};
        arr[3] = new int[]{0, 0, 1, 0, 1, 1};
        arr[4] = new int[]{1, 1, 0, 0, 1, 0};
        arr[5] = new int[]{1, 1, 1, 0, 0, 1};
//        int[][] arr = {
//                {0, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 1, 1},
//                {0, 0, 0, 0, 1, 1},
//                {1, 1, 0, 0, 1, 0},
//                {1, 1, 1, 0, 0, 0}
//        };

        //각 영역의 크기 저장 필요
        ArrayList<Integer> areaSizeList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //0이면 continue
                if (arr[i][j] == 0) continue;

                //1이면 DFS 수행
                DFS(i, j);

                //각 영역의 크기 저장 필요
                areaSizeList.add(cnt);

                //영역 크기 count 초기화
                cnt = 0;
            }
        }

        System.out.println("영역 개수 = " + areaSizeList.size());

        //ArrayList - 오름차순 정렲
        Collections.sort(areaSizeList);
        System.out.println("ArrayList 각 영역크기 오름차순 = " + areaSizeList);

        //ArrayList - 내림차순 정렲
        Collections.sort(areaSizeList, Collections.reverseOrder());
        System.out.println("ArrayList 각 영역크기 내림차순 = " + areaSizeList);

        //배열로 변환
        int[] resultArr = new int[areaSizeList.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = areaSizeList.get(i);
        }
        System.out.println("배열로 변환 = " + Arrays.toString(resultArr));

        //배열 - 버블 정렬 (오름차순)
        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr.length - i - 1; j++) {
                if(resultArr[j] > resultArr[j+1]) {
                    int tmp = resultArr[j];
                    resultArr[j] = resultArr[j+1];
                    resultArr[j+1] = tmp;
                }
            }
        }
        System.out.println("배열 버블정렬 오름차순 = " + Arrays.toString(resultArr));
    }

    static void DFS(int x, int y) {
        //노드 방문 표시 : 값을 1 -> 0으로 변경
        arr[x][y] = 0;
        cnt++;

        if (x - 1 >= 0 && arr[x - 1][y] == 1) DFS(x - 1, y);    //위
        if (y + 1 < n && arr[x][y + 1] == 1) DFS(x, y + 1);     //오른쪽
        if (x + 1 < n && arr[x + 1][y] == 1) DFS(x + 1, y);     //아래
        if (y - 1 >= 0 && arr[x][y - 1] == 1) DFS(x, y - 1);    //왼쪽
    }
}
