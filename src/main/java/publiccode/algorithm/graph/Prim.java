package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 프림 알고리즘 (Prim's Algorithm)
 * - 무향 연결 그래프가 주어질 때, '최소 스패닝 트리' 라고 부르는 서브 그래프를 찾는 알고리즘
 * <p>
 * - 각 간선에 대한 정보를 우선순위 큐(Priority Queue)에 담아 처리하는 방식으로 구현할 수 있다.
 * - 각 정점(노드)은 연결 리스트로 표현
 */
public class Prim {
    static final int NODE_MAX = 1001; //최대 노드 개수
    static final int EDGE_MAX = 200001; //최대 간선 개수 = 양방향 간선이므로 100,000개
    static Node[] adj;
    static int[] d = new int[NODE_MAX];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] inputStr = s.nextLine().split(" ");
        int n = Integer.parseInt(inputStr[0]); //정점 개수
        int m = Integer.parseInt(inputStr[1]); //간선 개수
        adj = new Node[n + 1]; //정점의 개수만큼 연결리스트 생성

        //노드 & 간선 정보 입력
        for (int i = 0; i < m; i++) {
            inputStr = s.nextLine().split(" ");
            //무방향 그래프를 가정했기 때문에 출발/도착이 따로 없음
            int a = Integer.parseInt(inputStr[0]); //노드1
            int b = Integer.parseInt(inputStr[1]); //노드2
            int c = Integer.parseInt(inputStr[2]); //가중치

            //무방향 그래프를 가정했기 때문에 a->b, b->a 모두 처리해줘야 한다.
            //a -> b
            Edge edge1 = new Edge(c, b);
            addNode(adj, a, edge1);
            //b -> a
            Edge edge2 = new Edge(c, a);
            addNode(adj, b, edge2);
        }

        //프림 알고리즘 시작
        PriorityQueue pq = new PriorityQueue(0); //힙(=우선순위 큐) 생성
        long result = 0;
        Edge firstEdge = new Edge(0, 1); //첫 간선의 가중치는 0
        push(pq, firstEdge); //루트 노드 삽입

        for (int i = 1; i <= n; i++) { //최소 신장 트리는 모든 노드가 들어가기 때문에 노드의 개수만큼 반복됨.
            int nextNode = -1;
            int nextCost = Integer.MAX_VALUE;

            //우선순위 큐는 오름차순으로 정렬되어 있음. (루트 노드가 제일 작은 값)
            //따라서, 우선순위 큐에서 간선 객체를 하나씩 추출하면서
            //해당 간선의 목적지 노드가 이전에 방문했던 곳인지 체크 후,
            //방문 안했던 간선이면 해당 간선을 선택한다.
            while (true) {
                Edge now = pop(pq); //우선순위 큐에서 간선 객체 추출
                if (now == null) break;
                nextNode = now.node; //간선 객체에서 도착 노드 인덱스 확인
                if (d[nextNode] == 0) { //도착지 노드가 이전에 방문한 곳이 아니라면
                    nextCost = now.cost; //해당 간선 선택 후 break;
                    break;
                }
            }

            //선택된 간선 정보 출력
            System.out.printf("노드[%d] 비용[%d]", nextNode, nextCost);
            if (nextCost == Integer.MAX_VALUE) {
                System.out.printf("연결 그래프가 아닙니다.");
            }
            System.out.println();

            result += nextCost; //최소 신장 트리를 구성하는데 들어가는 가중치 합산
            d[nextNode] = 1; //방문 처리

            //도착 노드에 연결된 간선 정보를 우선순위 큐에 삽입
            //  - 도착 노드의 연결 리스트를 전부 순회하면서 간선 데이터를 우선순위 큐에 넣음
            Node cur = adj[nextNode];
            while (cur != null) {
                push(pq, cur.edge); //노드 데이터의 간선 정보를 우선순위 큐에 삽입
                cur = cur.next; //연결 리스트의 모든 노드들을 순회
            }
        }
        System.out.println("최소 신장 트리의 비용(result) = " + result);
    }

    /**
     * 연결 리스트 - 노드 삽입
     *
     * @param target 각 연결 리스트의 첫 노드들의 배열
     * @param index  삽입할 위치
     * @param edge   삽입할 간선 정보
     */
    static void addNode(Node[] target, int index, Edge edge) {
        if (target[index] == null) {
            target[index] = new Node(edge, null);
        } else {
            Node node = new Node(edge, target[index]);
            target[index] = node;
        }
    }

    /**
     * 우선순위 큐 - 새 노드 삽입
     */
    static void push(PriorityQueue pq, Edge edge) {
        if (pq.count >= EDGE_MAX) return;

        //1. 새 간선을 우선순위 큐의 마지막 인덱스에 삽입
        pq.heap[pq.count] = edge;

        //2. 원소 삽입 후 상향식으로 힙(우선순위 큐) 재구성
        //  - 자식노드가 부모노드보다 값이 작다면 위로 올림
        int now = pq.count;
        int parent = (pq.count - 1) / 2; //부모 노드 인덱스 구하는 방법
        while (now > 0 && pq.heap[now].cost < pq.heap[parent].cost) {
            swap(pq.heap[now], pq.heap[parent]);
            now = parent;
            parent = (parent - 1) / 2;
        }
        pq.count++;
    }

    /**
     * 우선순위 큐 - 루트 노드 추출
     */
    static Edge pop(PriorityQueue pq) {
        if (pq.count <= 0) return null;

        //루트 노드 추출
        Edge result = pq.heap[0];
        pq.count--;

        //루트 노드 자리로 마지막 노드 이동
        pq.heap[0] = pq.heap[pq.count]; //바로 윗 줄에서 count-1 했으므로 마지막 노드 인덱스는 count와 같음.

        int nowIdx = 0; //루트 노드 index
        int leftChildIdx = 1; //왼쪽 자식 index
        int rightChildIdx = 2; //오른쪽 자식 index
        int targetIdx = nowIdx;

        //새 원소를 추출한 이후에 하향식으로 힙(우선순위 큐) 재구성
        while (leftChildIdx < pq.count) {
            if (pq.heap[targetIdx].cost > pq.heap[leftChildIdx].cost) {
                targetIdx = leftChildIdx;
            }
            if (pq.heap[targetIdx].cost > pq.heap[rightChildIdx].cost && rightChildIdx < pq.count) {
                targetIdx = rightChildIdx;
            }

            if (targetIdx == nowIdx) {
                break; //더 이상 내려가지 않아도 될 경우 종료
            } else {
                swap(pq.heap[nowIdx], pq.heap[targetIdx]);
                nowIdx = targetIdx;
                leftChildIdx = nowIdx * 2 + 1; //왼쪽 자식 인덱스 구하는 법
                rightChildIdx = nowIdx * 2 + 2; //오른쪽 자식 인덱스 구하는 법
            }
        }

        return result;
    }

    /**
     * 두 간선의 정보를 서로 교환
     */
    static void swap(Edge a, Edge b) {
        Edge tmp = new Edge(a.cost, a.node);

        a.cost = b.cost;
        a.node = b.node;

        b.cost = tmp.cost;
        b.node = tmp.node;
    }
}

/**
 * 노드(=정점) 구조체
 */
class Node {
    Edge edge;
    Node next;

    public Node(Edge edge, Node next) {
        this.edge = edge;
        this.next = next;
    }
}

/**
 * 간선 구조체
 */
class Edge {
    int cost;
    int node; //도착 노드

    public Edge(int cost, int node) {
        this.cost = cost;
        this.node = node;
    }
}

/**
 * 우선순위 큐 구조체
 */
class PriorityQueue {
    final int EDGE_MAX = 200001; //최대 간선 개수 = 양방향 간선이므로 100,000개
    Edge[] heap = new Edge[EDGE_MAX];
    int count;

    public PriorityQueue(int count) {
        this.count = count;
    }

    public PriorityQueue(Edge[] heap, int count) {
        this.heap = heap;
        this.count = count;
    }
}
