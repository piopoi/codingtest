package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 다익스트라의 최단 경로 알고리즘 (Dijkstra's Shortest Path Algorithm)
 */
/*
입력값
3 3 1
1 2 10
1 3 30
2 3 5

출력값
0   >> 노드 1에서 1까지 이동거리 : 1 -> 1(+0)
10  >> 노드 1에서 2까지 이동거리 : 1 -> 2(+10)
15  >> 노드 1에서 3까지 이동거리 : 1 -> 2(+10) -> 3(+5)
 */
public class Dijkstra {

    static final int NODE_MAX = 20001; //최대 노드 수
    static final int EDGE_MAX = 600001; //최대 간선 수 = 양방향이므로 300,000개
    static DiNode[] adj;
    static int[] answer = new int[NODE_MAX];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] inputStr = s.nextLine().split(" ");
        int n = Integer.parseInt(inputStr[0]); //정점 개수
        int m = Integer.parseInt(inputStr[1]); //간선 개수
        int k = Integer.parseInt(inputStr[2]); //출발 노드

        adj = new DiNode[n + 1]; //노드의 개수만큼 연결리스트 생성
        for (int i = 1; i <= n; i++) {
            answer[i] = Integer.MAX_VALUE; //모든 노드로 갈 수 있는 비용을 무한대로 초기화
        }

        //우선순위 큐 생성
        DiPriorityQueue pq = new DiPriorityQueue(0);

        //노드 & 간선 정보 입력
        for (int i = 0; i < m; i++) {
            inputStr = s.nextLine().split(" ");
            int a = Integer.parseInt(inputStr[0]); //출발 노드
            int b = Integer.parseInt(inputStr[1]); //도착 노드
            int c = Integer.parseInt(inputStr[2]); //이동 비용

            //a->b 이동하는 간선 객체 생성
            DiEdge edge = new DiEdge(b, c);

            //배열에 노드 추가
            addNode(adj, a, edge);

            //방향(=단방향) 그래프이기 때문에 b->a는 처리 안함
        }

        /**
         * 다익스트라 알고리즘 시작
         */
        //출발 노드 객체 생성 & 우선순위 큐에 간선 객체 삽입
        answer[k] = 0; //출발 노드의 비용 = 0
        DiEdge start = new DiEdge(k, 0);
        push(pq, start);

        while (true) {
            DiEdge now = pop(pq); //우선순위 큐에서 간선 객체 추출
            if (now == null) break; //큐에서 원소가 바닥날 때까지 진행 -> 모든 간선을 큐에 담았다가 처리하게 됨.

            int curNode = now.node; //도착 노드 인덱스
            int curCost = now.cost; //이동 비용

            if (answer[curNode] < curCost) { //최단 경로가 아니라면,
                continue;
            } else { //방문한 노드가 새 노드 라면,
                DiNode cur = adj[curNode];
                while (cur != null) { //연결 리스트에서 새로 방문한 노드에 연결된 노드를 전부 확인
                    DiEdge tmp = cur.edge;
                    tmp.cost += curCost; //새로 방문한 노드에 연결된 노드로 이동하는 비용 합산
                    if (tmp.cost < answer[tmp.node]) { //테이블의 정보보다 최단 경로가 나왔다면
                        answer[tmp.node] = tmp.cost; //합산 이동 비용으로 테이블 갱신
                        push(pq, tmp);
                    }
                    cur = cur.next;
                }
            }
        }

        //k 노드에서 출발해서 각 노드로 이동하는 최단경로 이동거리 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(k + " -> " + i + " : ");
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF"); //해당 노드로는 갈 수 없다는 뜻이 됨.
            } else {
                System.out.println(answer[i]);
            }
        }
    }

    /**
     * 우선순위 큐 - 새 노드 삽입
     * 프림 알고리즘 소스와 완전 일치함.
     */
    static void push(DiPriorityQueue pq, DiEdge edge) {
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
     * 프림 알고리즘 소스와 완전 일치함.
     */
    static DiEdge pop(DiPriorityQueue pq) {
        if (pq.count <= 0) return null;

        //루트 노드 추출
        DiEdge result = pq.heap[0];
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
     * 간선 정보 교환
     * 프림 알고리즘 소스와 완전 일치함.
     */
    static void swap(DiEdge a, DiEdge b) {
        DiEdge tmp = new DiEdge(a.node, a.cost);

        a.cost = b.cost;
        a.node = b.node;

        b.cost = tmp.cost;
        b.node = tmp.node;
    }

    /**
     * 연결 리스트 - 노드 삽입
     * 프림 알고리즘 소스와 완전 일치함.
     *
     * @param target 각 연결 리스트의 첫 노드들의 배열
     * @param index  삽입할 위치
     * @param edge   삽입할 간선 정보
     */
    static void addNode(DiNode[] target, int index, DiEdge edge) {
        if (target[index] == null) {
            target[index] = new DiNode(edge, null);
        } else {
            DiNode node = new DiNode(edge, target[index]);
            target[index] = node;
        }
    }
}

/**
 * 다익스트라 간선 구조체
 * 프림 알고리즘 소스와 완전 일치함.
 */
class DiEdge {
    int node;
    int cost;

    public DiEdge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

/**
 * 노드(=정점) 구조체
 * 프림 알고리즘 소스와 완전 일치함.
 */
class DiNode {
    DiEdge edge;
    DiNode next;

    public DiNode(DiEdge edge, DiNode next) {
        this.edge = edge;
        this.next = next;
    }
}

/**
 * 우선순위 큐 구조체
 * 프림 알고리즘 소스와 완전 일치함.
 */
class DiPriorityQueue {
    final int EDGE_MAX = 600001; //최대 간선 개수 = 양방향 간선이므로 100,000개
    DiEdge[] heap = new DiEdge[EDGE_MAX];
    int count;

    public DiPriorityQueue(int count) {
        this.count = count;
    }
}
