package publiccode.datastructure.tree;

/**
 * 세그먼트 트리 (Segment Tree)
 *
 * O(logN)의 시간 복잡도를 가진다.
 */
public class SegmentTree {
    static int[] a = {7, 1, 9, 5, 6, 4, 1}; //startIdx, endIdx
    static int[] tree = new int[a.length * 4]; //nodeIdx

    public static void main(String[] args) {
        //구간 합 트리의 인덱스를 제외하고는 모두 인덱스 0부터 시작한다.

        //1. 구간 합 트리 생성하기
        init(0, a.length - 1, 1); //구간 합 트리의 인덱스는 1부터 시작한다.

        //2. 0 ~ 6 구간 합 구하기
        System.out.printf("0부터 6까지의 구간 합: %d\n", sum(0, a.length - 1, 1, 0, 6));

        //3. 구간 합 수정하기
        System.out.println("Index 5의 원소를 +3 만큼 수정");
        update(0, a.length - 1, 1, 5, 3);

        //4. 3 ~ 6 구간 합 다시 구하기
        System.out.printf("3부터 6까지의 구간 합: %d\n", sum(0, a.length - 1, 1, 3, 6));
    }

    /**
     * 구간 합 트리 초기화
     *
     * @param start,end 완전이진트리에서 구간 합을 구하고자 하는 구간의 시작/끝 인덱스
     * @param node      구간 합 트리의 루트 노드 인덱스
     */
    static int init(int start, int end, int node) {
        //1. 리프 노드인 경우, 합산할 필요가 없으므로 그대로 넣어줌.
        if (start == end) return tree[node] = a[start];

        //2. 리프 노드가 아닌 경우, 모든 자식 노드의 값을 합산하여 넣어줌.
        int mid = (start + end) / 2;
        int leftChildVal = init(start, mid, node * 2); //왼쪽 자식 합
        int rightChildVal = init(mid + 1, end, node * 2 + 1); //오른쪽 자식 합
        return tree[node] = leftChildVal + rightChildVal;
    }

    /**
     * 구간 합 구하기
     * 시간 복잡도 = O(logN)
     *
     * @param start,end  완전이진트리에서 구간 합을 구하고자 하는 구간의 시작/끝 인덱스
     * @param node       구간 합 트리의 루트 노드 인덱스
     * @param left,right 구간 합을 구하고자 하는 범위
     */
    static int sum(int start, int end, int node, int left, int right) {
        //1. 범위 밖인 경우.
        if (right < start || end < left) return 0;

        //2. 범위 안에 있는 경우.
        if (left <= start && end <= right) return tree[node];

        //3. 그 외의 경우, 두 부분으로 나누어 합을 구한다.
        int mid = (start + end) / 2;
        int leftChildVal = sum(start, mid, node * 2, left, right);
        int rightChildVal = sum(mid + 1, end, node * 2 + 1, left, right);
        return leftChildVal + rightChildVal;
    }

    /**
     * 구간 합 수정하기
     *
     * @param start,end 완전이진트리에서 구간 합을 구하고자 하는 구간의 시작/끝 인덱스
     * @param node      구간 합 트리의 루트 노드
     * @param index     구간 합 트리의 수정하고자 하는 노드 인덱스
     * @param dif       수정할 값
     */
    static void update(int start, int end, int node, int index, int dif) {
        //1. 범위 밖에 있는 경우
        if (index < start || end < index) return;

        //2. 범위 안에 있으면, 내려가면서 다른 원소도 갱신
        tree[node] += dif; //루트 노드 값 갱신
        if (start == end) { //노드가 1개인 그래프인 경우
            return;
        } else {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, dif);
            update(mid + 1, end, node * 2 + 1, index, dif);
        }

    }
}
