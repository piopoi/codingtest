package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 인접 행렬 (Adjacency Matrix)
 * - 2차원 배열을 사용하여 그래프를 구현하는 방식.
 * <p>
 * 무방향 비가중치 그래프와 인접행렬
 * - 무방향 그래프 : 모든 간선이 방향성을 가지지 않는 그래프.
 * - 비가중치 그래프 : 모든 간선에 가중치가 없는 그래프.
 * - 무방향 비가중치 그래프가 주어졌을 때, 연결되어 있는 상황을 인접 행렬로 출력할 수 있다.
 */
public class AdjacencyMatrix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //1. 노드, 간선 개수 입력.
        System.out.println("노드와 간선 개수를 입력하세요.");
        String[] input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
        int n = Integer.parseInt(input[0]); //노드 개수
        int m = Integer.parseInt(input[1]); //간선 개수
        
        int[][] arr = new int[n + 1][n + 1]; //배열 생성. index가 1부터 시작하도록 출력할거라 +1 해준다.

        //2. 간선이 어떻게 연결되어 있는지 입력.
        System.out.println("간선이 어떻게 연결되어 있는지 입력하세요.");
        for (int i = 0; i < m; i++) {
            input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        //3. 입력한 2차원 배열 출력.
        System.out.println("입력한 2차원 배열 출력합니다.");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println(); //줄바꿈
        }
    }

}
/*

노드와 간선 개수를 입력하세요.
5 3

간선이 어떻게 연결되어 있는지 입력하세요.
1 2
3 4
4 5

입력한 2차원 배열 출력합니다.
0 1 0 0 0
1 0 0 0 0
0 0 0 1 0
0 0 1 0 1
0 0 0 1 0

 */
