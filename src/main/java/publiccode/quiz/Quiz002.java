package publiccode.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * com.practice.quiz.Quiz1 재연습
 */
public class Quiz002 {
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
//                    areaSizeList.add(DFS(i, j)); //DFS
                    areaSizeList.add(BFS(i, j)); //BFS
                }
            }
        }

        Collections.sort(areaSizeList, Collections.reverseOrder()); //내림차순 정렬
        for (int a : areaSizeList) {
            System.out.print(a + " ");
        }
    }

    public static int DFS(int x, int y) {
        arr[x][y] = 0; //방문처리
        int size = 1;

        if (x - 1 >= 0 && arr[x - 1][y] == 1) size += DFS(x - 1, y);
        if (y - 1 >= 0 && arr[x][y - 1] == 1) size += DFS(x, y - 1);
        if (x + 1 < n && arr[x + 1][y] == 1) size += DFS(x + 1, y);
        if (y + 1 < n && arr[x][y + 1] == 1) size += DFS(x, y + 1);

        return size;
    }

    public static int BFS(int x, int y) {
        int size = 0;
        int[] xArr = {-1, 1, 0, 0};
        int[] yArr = {0, 0, -1, 1};

        Queue<Area> q = new LinkedList<>();
        q.add(new Area(x, y));

        while (!q.isEmpty()) {
            Area a = q.poll();

            //하나의 영역이 queue에 2번 이상 들어가는 경우가 발생하기 때문에
            //line 77에서 한 번 걸러줬어도 필수로 체크해야함.
            if(arr[a.x][a.y] == 0) continue;

            arr[a.x][a.y] = 0; //방문처리
            size++; //영역 size + 1

            for (int i = 0; i < xArr.length; i++) {
                int newX = a.x + xArr[i];
                int newY = a.y + yArr[i];

                if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

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
