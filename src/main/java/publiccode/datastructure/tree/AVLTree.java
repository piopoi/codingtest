package publiccode.datastructure.tree;

/**
 * AVL 트리
 *  = 균형잡힌 이진 트리
 * <p>
 * AVL 트리의 균형 잡기는 각 노드가 '삽입 될 때' 마다 수행되어야 한다.
 * <p>
 * '삽입' 과정에 소요되는 시간 복잡도는 O(logN)이다.
 * 따라서, 각 트리의 균형 잡기는 삽입 시에 거치는 모든 노드에 대하여 수행된다는 점에서
 * O(1)(=즉시)의 시간복잡도를 만족해야 한다.
 */
public class AVLTree {

    static AVLNode root;

    public static void main(String[] args) {
        root = insertNode(root, 7);
        root = insertNode(root, 6);
        root = insertNode(root, 5);
        root = insertNode(root, 3);
        root = insertNode(root, 1);
        root = insertNode(root, 9);
        root = insertNode(root, 8);
        root = insertNode(root, 12);
        root = insertNode(root, 16);
        root = insertNode(root, 18);
        root = insertNode(root, 23);
        root = insertNode(root, 21);
        root = insertNode(root, 14);
        root = insertNode(root, 15);
        root = insertNode(root, 19);
        root = insertNode(root, 20);

        display(root, 1);
    }

    /**
     * AVL 트리의 출력
     * <p>
     * AVL 트리는 삽입되는 과정을 면밀히 살펴보는 것이 중요하므로,
     * 트리 구조를 적절히 보여줄 수 있는 방식으로 출력해야 한다.
     * <p>
     * 일반적으로 트리의 너비가 높이보다 크다는 점에서
     * 세로 방향으로 출력하는 함수를 구현할 수 있다.
     */
    static void display(AVLNode node, int level) {
        if (node != null) {
            display(node.rightChild, level + 1);
            System.out.println();

            if (node == root) {
                System.out.printf("Root: ");
            }

            for (int i = 0; i < level && node != root; i++) {
                System.out.printf("       ");
            }

            System.out.printf("%d(%d)", node.data, getHeight(node));

            display(node.leftChild, level + 1);
        }
    }

    /**
     * AVL 트리의 노드 삽입
     * <p>
     * AVL 트리의 삽입 과정은 일반적인 이진 탐색 트리와 흡사하지만,
     * 삽입 시에 거치는 모든 노드에 대하여 균형 잡기를 수행해주어야 한다는 특징이 있다.
     */
    static AVLNode insertNode(AVLNode node, int data) {
        if (node == null) {
            node = new AVLNode(data, 1, null, null);
        } else if (data < node.data) {
            node.leftChild = insertNode(node.leftChild, data);
            node = balance(node);
        } else if (data > node.data) {
            node.rightChild = insertNode(node.rightChild, data);
            node = balance(node);
        } else {
            System.out.println("데이터 중복이 발생했습니다.");
        }

        return node;
    }

    /**
     * 균형 잡기
     */
    static AVLNode balance(AVLNode node) {
        int difference = getDifference(node);
        if (difference >= 2) {
            if (getDifference(node.leftChild) >= 1) {
                node = rotateLL(node);
            } else {
                node = rotateLR(node);
            }
        } else if (difference <= -2) {
            if (getDifference(node.rightChild) <= -1) {
                node = rotateRR(node);
            } else {
                node = rotateRL(node);
            }
        }
        setHeight(node); //회전 이후에 높이를 다시 계산
        return node;
    }

    /**
     * LL 회전
     */
    static AVLNode rotateLL(AVLNode node) {
        AVLNode leftChild = node.leftChild;

        //1. 기준노드의 왼쪽자식 자리에 기존 왼쪽자식의 오른쪽자식을 넣고,
        node.leftChild = leftChild.rightChild;

        //2. 기존 왼쪽자식의 오른쪽자식 자리에 기준노드를 넣음.
        leftChild.rightChild = node;

        setHeight(node); //회전 이후 높이를 다시 계산
        return leftChild; //이후에 setHeight() 수행
    }

    /**
     * RR 회전
     */
    static AVLNode rotateRR(AVLNode node) {
        AVLNode rightChild = node.rightChild;

        //1. 기준노드의 오른쪽자식 자리에 기존 오른쪽자식의 왼쪽자식을 넣고,
        node.rightChild = rightChild.leftChild;

        //2. 기존 오른쪽자식의 왼쪽자식 자리에 기준노드를 넣음.
        rightChild.leftChild = node;

        setHeight(node); //회전 이후 높이를 다시 계산
        return rightChild; //이후에 setHeight() 수행
    }

    /**
     * LR 회전
     * - RR 회전과 LL 회전의 조합
     */
    static AVLNode rotateLR(AVLNode node) {
        AVLNode leftChild = node.leftChild;

        //1. 기준 노드의 왼쪽 자식을 기준으로 RR 회전 수행
        node.leftChild = rotateRR(leftChild);
        setHeight(node.leftChild); //회전 이후에 높이를 다시 계산

        //2. 기준 노드에서 LL 회전 수행
        return rotateLL(node);
    }

    /**
     * RL 회전
     * - LL 회전과 RR 회전의 조합
     */
    static AVLNode rotateRL(AVLNode node) {
        AVLNode rightChild = node.rightChild;

        //1. 기준 노드의 오른쪽 자식을 기준으로 LL 회전 수행
        node.rightChild = rotateLL(rightChild);
        setHeight(node.rightChild); //회전 이후에 높이를 다시 계산

        //2. 기준 노드에서 RR 회전 수행
        return rotateRR(node);
    }

    /**
     * 특정 노드의 균형 인수 구하기
     */
    static int getDifference(AVLNode node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.leftChild) - getHeight(node.rightChild);
        }
    }

    /**
     * 특정 노드의 높이 계산
     *   = 왼쪽 자식의 높이와 오른쪽 자식의 높이 중 더 큰 값에 +1
     */
    static void setHeight(AVLNode node) {
        node.height = getMax(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    /**
     * 노드의 높이(Height) 반환
     */
    static int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 두 정수 중 큰 값 반환
     */
    static int getMax(int a, int b) {
        return a > b ? a : b;
    }
}

/**
 * AVL 트리의 노드 구조체
 */
class AVLNode {
    int data;
    int height;
    AVLNode leftChild;
    AVLNode rightChild;

    public AVLNode(int data, int height, AVLNode leftChild, AVLNode rightChild) {
        this.data = data;
        this.height = height;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
