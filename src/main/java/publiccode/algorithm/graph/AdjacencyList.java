package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 방향 가중치 그래프 & 인접 리스트
 * <p>
 * 인접 리스트 (Adjacency List)
 * - 리스트를 사용하여 그래프를 구현하는 방식.
 * <p>
 * 방향 가중치 그래프와 인접리스트
 * - 방향 그래프 : 모든 간선이 방향을 가지는 그래프.
 * - 가중치 그래프 : 모든 간선에 가중치가 있는 그래프.
 * - 방향 가중치 그래프가 주어졌을 때, 연결되어 있는 상황을 인접 리스트로 출력할 수 있다.
 * <p>
 * 소스 출처
 * - [그래프] 그래프의 표현 (인접 행렬, 인접 리스트, 간선 리스트) (https://livecoding.tistory.com/49)
 */
public class AdjacencyList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //1. 노드, 간선 개수 입력.
        System.out.println("노드와 간선 개수를 입력하세요.");
        String[] input = s.nextLine().split(" ");
        int n = Integer.parseInt(input[0]); //노드 개수
        int m = Integer.parseInt(input[1]); //간선 개수

        //2. 배열 선언 및 초기화
        //  - index가 1부터 시작하도록 출력할거라 +1 해준다.
        AdjacencyListNode[] arr = new AdjacencyListNode[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new AdjacencyListNode(); //root 노드 초기화
            arr[i].nextNode = null; //root가 null을 바라보도록 초기화
        }

        //3. 간선 정보 입력
        System.out.println("간선이 어떻게 연결되어 있는지 입력하세요.");
        for (int i = 0; i < m; i++) {
            input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);
            addFront(arr[x], y, distance);
        }

        //4. 출력
        for (int i = 1; i <= n; i++) {
            System.out.printf("원소 [%d]: ", i);
            showAll(arr[i]);
            System.out.println();
        }
    }

    /**
     * 연결 리스트의 노드 삽입 함수
     */
    static void addFront(AdjacencyListNode root, int index, int distance) {
        AdjacencyListNode node = new AdjacencyListNode();
        node.index = index;
        node.distance = distance;
        node.nextNode = root.nextNode;
        root.nextNode = node;
    }

    /**
     * 연결 리스트의 출력 함수
     */
    static void showAll(AdjacencyListNode root) {
        AdjacencyListNode curNode = root.nextNode;
        while (curNode != null) {
            System.out.printf("%d(거리: %d) ", curNode.index, curNode.distance);
            curNode = curNode.nextNode;
        }
    }
}

/**
 * 노드 구조체
 */
class AdjacencyListNode extends Object { //배열 사용을 위한 Object 상속
    int index; //방향 = 바라보고 있는 index
    int distance; //가중치 = 거리로 표현
    AdjacencyListNode nextNode; //연결 리스트라서 다음 노드의 정보가 있어야함.
}
