package publiccode.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 방향 비가중치 그래프 & 인접 리스트
 * - AdjacencyList.java와 다른 점은 '가중치' 정보가 빠져서 ArrayList로 구현이 가능해졌다.
 * <p>
 * 소스 출처
 * - [그래프] 그래프의 표현 (인접 행렬, 인접 리스트, 간선 리스트) (https://livecoding.tistory.com/49)
 */
public class AdjacencyList2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //1. 노드, 간선 개수 입력.
        System.out.println("노드와 간선 개수를 입력하세요.");
        String[] input = s.nextLine().split(" ");
        int n = Integer.parseInt(input[0]); //노드 개수
        int m = Integer.parseInt(input[1]); //간선 개수

        //2. ArrayList<Integer> 형태의 배열 선언
        //  - index가 1부터 시작하도록 출력할거라 +1 해준다.
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        //3. 간선 정보 입력
        System.out.println("간선이 어떻게 연결되어 있는지 입력하세요.");
        for (int i = 0; i < m; i++) {
            input = s.nextLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            arr[u].add(v);
            arr[v].add(u);
        }

        //4. 출력
        System.out.println("출력");
        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("Node[%d] ", i);
            for (int j = 0; j < arr[i].size(); j++) {
                System.out.printf("%d ", arr[i].get(j));
            }
            System.out.println();
        }
    }
}
/*

노드와 간선 개수를 입력하세요.
6 8

간선이 어떻게 연결되어 있는지 입력하세요.
1 2
1 5
2 3
2 4
2 5
3 4
4 5
4 6

출력
Node[1] 2 5
Node[2] 1 3 4 5
Node[3] 2 4
Node[4] 2 3 5 6
Node[5] 1 2 4
Node[6] 4

 */
