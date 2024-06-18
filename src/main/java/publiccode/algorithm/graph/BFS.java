package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 그래프 - 너비 우선 탐색 (BFS, Breadth First Search)
 * <p>
 * 연결리스트로 구현.
 * <p>
 * 방문 순서 조건은 없는 구현소스.
 */
public class BFS {
    static BFSNode[] a;
    static int n; //노드 수
    static int m; //간선 수
    static int[] c; //현재 노드를 방문했는지 체크하는 변수

    public static void main(String[] args) {
        //노드, 간선 개수 입력.
        Scanner s = new Scanner(System.in);
        System.out.println("노드와 간선 개수를 입력하세요.");
        String[] input = s.nextLine().split(" ");
        n = Integer.parseInt(input[0]); //노드 개수
        m = Integer.parseInt(input[1]); //간선 개수
        a = new BFSNode[n + 1];
        c = new int[n + 1];

        //초기화
        for (int i = 1; i <= n; i++) {
            a[i] = new BFSNode();
            a[i].next = null;
        }

        //간선 정보 입력
        System.out.println("간선이 어떻게 연결되어 있는지 입력하세요.");
        for (int i = 0; i < m; i++) {
            input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            addFront(a[x], y);
            addFront(a[y], x);
        }

        //BFS 수행
        bfs(1);
    }

    /**
     * 너비 우선 탐색
     */
    public static void bfs(int start) {
        //큐 초기화
        BFSQueue q = new BFSQueue();
        q.front = null;
        q.rear = null;
        q.count = 0;

        queuePush(q, start); //start 노드를 큐에 넣음
        c[start] = 1; //큐에 넣은 start 노드를 방문 처리함.

        while (q.count != 0) {
            int x = queuePop(q); //큐에서 노드 1개 추출(=방문)
            System.out.printf("%d ", x); //방문한 원소 출력

            //위에서 추출한 노드의 연결된 노드들을 하나씩 확인하면서,
            //방문했는지 확인하여 안했으면 큐에 넣는다.
            BFSNode cur = a[x].next;
            while (cur != null) {
                int next = cur.index;
                if (c[next] != 1) { //방문 안한 노드라면
                    queuePush(q, next); //큐의 맨 뒤에 넣음. 바깥 while에서 순서대로 추출하여 처리함.
                    c[next] = 1; //방문 처리
                }
                cur = cur.next;
            }
        }
    }

    /**
     * 연결리스트 노드 추가
     */
    public static void addFront(BFSNode root, int index) {
        BFSNode node = new BFSNode();
        node.index = index;
        node.next = root.next;
        root.next = node;
    }

    /**
     * Queue 삽입
     */
    public static void queuePush(BFSQueue queue, int index) {
        BFSNode node = new BFSNode();
        node.index = index;
        node.next = null;

        if (queue.count == 0) {
            queue.front = node; //큐가 비어있다면 앞에 노드 추가
        } else {
            queue.rear.next = node; //큐에 노드가 있다면, 맨 뒤 노드에 next 노드 추가
        }
        queue.rear = node; //결과적으로 항상 큐의 꼬리에 노드 추가
        queue.count++; //큐의 노드 개수 +1
    }

    /**
     * Queue 추출
     */
    public static int queuePop(BFSQueue queue) {
        if (queue.count == 0) {
            System.out.println("큐 언더플로우가 발생했습니다.");
            return -9999;
        }

        //front에서 1개 노드를 꺼낸다.
        BFSNode node = queue.front;
        int index = node.index;
        queue.front = node.next;
        queue.count--; //노드 1개 빠져서 -1
        return index;
    }
}

/**
 * 연결리스트의 노드
 */
class BFSNode extends Object {
    int index;
    BFSNode next;
}

class BFSQueue extends Object {
    BFSNode front;
    BFSNode rear;
    int count;
}
