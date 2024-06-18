package publiccode.datastructure.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        BSTNode root = null;

        //삽입
        root = insertNode(root, 30);
        root = insertNode(root, 17);
        root = insertNode(root, 48);
        root = insertNode(root, 5);
        root = insertNode(root, 23);
        root = insertNode(root, 37);
        root = insertNode(root, 50);

        //탐색 - 전위순회
        preOrder(root);

        System.out.println();

        //삭제
        root = deleteNode(root, 17);

        //탐색 - 전위순회
        preOrder(root);
    }

    /**
     * 이진 탐색 트리의 노드 삭제
     *
     * @param root 최상위 노드
     * @param data 삭제할 값 - 해당 값을 지닌 노드를 찾아서 삭제하는 함수
     * @return
     */
    public static BSTNode deleteNode(BSTNode root, int data) {
        BSTNode node = null;

        if (root == null) return null;

        if (root.data > data) {
            root.leftChild = deleteNode(root.leftChild, data);

        } else if (root.data < data) {
            root.rightChild = deleteNode(root.rightChild, data);

        } else { //root.data == data
            if (root.leftChild != null && root.rightChild != null) {
                //자식이 둘 다 존재하는 경우, 삭제할 노드의 자리에 자기 다음으로 큰 노드를 넣는다.
                //자기 다음으로 큰 노드 = 자기 자신의 오른쪽 자식 노드들 중에서 가장 작은 노드.
                node = findMinNode(root.rightChild);
                root.data = node.data;

                //삭제 노드 자리에 대신 들어간 노드는 원래 자리에서 삭제
                root.rightChild = deleteNode(root.rightChild, node.data);

            } else {
                //자식이 하나만 존재하는 경우, 자식 노드를 부모 자리에 넣음.
                return (root.leftChild != null) ? root.leftChild : root.rightChild;
            }
        }
        return root;
    }

    /**
     * 이진 탐색 트리의 가장 작은 원소 찾기 함수
     * - 이진 탐색 트리에서는 왼쪽 자식이 더 작은 값을 가지므로 leftChild만 확인하면 된다.
     *
     * @param root 탐색 기준 노드
     * @return
     */
    public static BSTNode findMinNode(BSTNode root) {
        BSTNode node = root;
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    /**
     * 이진 탐색 트리에 노드 삽입
     */
    public static BSTNode insertNode(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data, null, null);
            return root;
        } else {
            if (root.data > data) {
                root.leftChild = insertNode(root.leftChild, data);
            } else {
                root.rightChild = insertNode(root.rightChild, data);
            }
            return root;
        }
    }

    /**
     * 노드 검색
     *
     * @param root 탐색 시작 노드
     * @param data 찾는 값
     * @return
     */
    public static BSTNode searchNode(BSTNode root, int data) {
        if (root == null) return null;
        if (root.data == data) {
            return root;
        } else if (root.data > data) {
            return searchNode(root.leftChild, data);
        } else {
            return searchNode(root.rightChild, data);
        }
    }

    /**
     * 이진 트리의 전위 순회
     * <p>
     * 1. 자기 자신을 출력한다.
     * 2. 왼쪽 자식을 방문한다.
     * 3. 오른쪽 자식을 방문한다.
     */
    public static void preOrder(BSTNode root) {
        if (root == null) return;
        System.out.printf("%d ", root.data);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }
}

/**
 * 이진 탐색 트리의 노드 구조체
 */
class BSTNode {
    int data;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode() {
    }

    public BSTNode(int data, BSTNode leftChild, BSTNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
