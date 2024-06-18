package quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Quiz001 {
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

        List<Integer> areaSizeList = new ArrayList<>(); //각 영역의 size list

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    //방문하면 1 -> 0 으로 값을 변경한다.
                    //areaSizeList.add(DFS(i, j)); //DFS
                    areaSizeList.add(BFS(i, j)); //BFS
                }
            }
        }

        areaSizeList.stream()
                .sorted(Comparator.reverseOrder()) //오름차순 정렬
                .forEach(i -> System.out.print(i + " "));
        ;
    }

    /**
     * DFS 탐색 수행 후 영역 크기 반환
     */
    public static int DFS(int x, int y) {
        arr[x][y] = 0; //방문처리
        int size = 1;

        if (x - 1 >= 0 && arr[x - 1][y] == 1) size += DFS(x - 1, y);
        if (y + 1 < n && arr[x][y + 1] == 1) size += DFS(x, y + 1);
        if (x + 1 < n && arr[x + 1][y] == 1) size += DFS(x + 1, y);
        if (y - 1 >= 0 && arr[x][y - 1] == 1) size += DFS(x, y - 1);

        return size;
    }

    /**
     * BFS 탐색 수행 후 영역 크기 반환
     */
    public static int BFS(int x, int y) {
        int size = 0;

        Queue<Area> q = new LinkedList<>();
        q.add(new Area(x, y));

        int[] xArr = {-1, 1, 0, 0};
        int[] yArr = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Area area = q.poll();

            if(arr[area.x][area.y] == 0) continue;

            arr[area.x][area.y] = 0; //방문처리
            size++;

            for (int i = 0; i < xArr.length; i++) {
                int newX = area.x + xArr[i];
                int newY = area.y + yArr[i];

                if(newX < 0 || n <= newX || newY < 0 || n <= newY) continue;

                if (arr[newX][newY] == 1) {
                    q.add(new Area(newX, newY));
                }
            }
        }

        return size;
    }

    public static class Area {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
