package publiccode.algorithm.graph;

import java.util.Scanner;

/**
 * 그래프 - 깊이 우선 탐색 (DFS, Depth First Search)
 * <p>
 * 연결리스트로 구현.
 * <p>
 * 방문 순서 조건은 없는 구현소스.
 */
public class DFS {

    static DFSNode[] a;
    static int n; //노드 수
    static int m; //간선 수
    static int[] c; //현재 노드를 방문했는지 체크하는 변수

    public static void main(String[] args) {
        //1. 노드, 간선 개수 입력
        System.out.println("노드와 간선의 개수를 입력하세요.");
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
        n = Integer.parseInt(input[0]); //노드 개수
        m = Integer.parseInt(input[1]); //간선 개수
        a = new DFSNode[n + 1];
        c = new int[n + 1];

        //2. 초기화
        for (int i = 1; i <= n; i++) {
            a[i] = new DFSNode();
            a[i].next = null;
        }

        //3. 간선 정보 입력
        System.out.println("간선의 연결 정보를 입력하세요.");
        for (int i = 0; i < m; i++) {
            input = s.nextLine().split(" "); //x, y값은 띄어쓰기로 구분
            int x = Integer.parseInt(input[0]); //노드 개수
            int y = Integer.parseInt(input[1]); //간선 개수
            addFront(a[x], y);
            addFront(a[y], x);
        }

        //4. DFS 수행
        //  - 1부터 수행함..
        dfs(1);
    }

    /**
     * 깊이 우선 탐색
     */
    public static void dfs(int x) {
        if (c[x] == 1) return; //해당 노드를 방문했으면 값이 1이므로 이 경우 return
        c[x] = 1; //방문 처리
        System.out.printf("%d ", x);

        //연결된 다음 노드 dfs 수행 - 재귀
        DFSNode cur = a[x].next;
        while (cur != null) {
            int next = cur.index;
            dfs(next);
            cur = cur.next;
        }
    }

    /**
     * 연결리스트 노드 추가
     */
    public static void addFront(DFSNode root, int index) {
        DFSNode node = new DFSNode();
        node.index = index;
        node.next = root.next;
        root.next = node;
    }
}

/**
 * 연결리스트의 노드
 */
class DFSNode extends Object {
    int index;
    DFSNode next;
}
