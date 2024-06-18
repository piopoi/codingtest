package publiccode.datastructure;

/**
 * 이진 탐색 트리 구현
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        //루트 노드 생성
        Node rootNode = null;

        //삽입
//        rootNode = addNode(rootNode, 30);
//        rootNode = addNode(rootNode, 17);
//        rootNode = addNode(rootNode, 48);
//        rootNode = addNode(rootNode, 5);
//        rootNode = addNode(rootNode, 23);
//        rootNode = addNode(rootNode, 37);
//        rootNode = addNode(rootNode, 50);

        //삽입 (재귀호출)
        rootNode = addNodeWithRecursiveCall(rootNode, 30);
        rootNode = addNodeWithRecursiveCall(rootNode, 17);
        rootNode = addNodeWithRecursiveCall(rootNode, 48);
        rootNode = addNodeWithRecursiveCall(rootNode, 5);
        rootNode = addNodeWithRecursiveCall(rootNode, 23);
        rootNode = addNodeWithRecursiveCall(rootNode, 37);
        rootNode = addNodeWithRecursiveCall(rootNode, 50);

        //노드 탐색(전위 순회 방법)
        printNode(rootNode);
        System.out.println();

        //노드 검색
        System.out.println(searchNode(rootNode, 17).toString());
        System.out.println();

        //노드 삭제
        rootNode = removeNode(rootNode, 17);
        printNode(rootNode);
        System.out.println();
        rootNode = removeNode(rootNode, 23);
        printNode(rootNode);
        System.out.println();
        rootNode = removeNode(rootNode, 50);
        printNode(rootNode);
        System.out.println();
    }

    /**
     * 노드 추가 without 재귀호출
     *
     * @param rootNode
     * @param inputValue
     * @return
     */
    public static Node addNode(Node rootNode, int inputValue) {
        if (rootNode == null) {
            rootNode = new Node(inputValue, null, null);
        } else {
            Node currentNode = rootNode;
            Node nextNode = currentNode;

            while (nextNode != null) {
                currentNode = nextNode;

                if (currentNode.value > inputValue) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(inputValue, null, null);
                        break;
                    } else {
                        nextNode = currentNode.leftChild;
                    }
                } else if (currentNode.value < inputValue) {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(inputValue, null, null);
                        break;
                    } else {
                        nextNode = currentNode.rightChild;
                    }
                } else {
                    System.out.println("기존 노드와 동일한 값을 가진 노드는 추가할 수 없습니다.");
                    break;
                }
            }
        }
        return rootNode;
    }

    /**
     * 노드 추가 with 재귀호출
     *
     * @param node
     * @param inputValue
     * @return
     */
    public static Node addNodeWithRecursiveCall(Node node, int inputValue) {
        if (node == null) {
            node = new Node(inputValue, null, null);
        } else {
            if (node.value > inputValue) {
                node.leftChild = addNodeWithRecursiveCall(node.leftChild, inputValue);
            } else if (node.value < inputValue) {
                node.rightChild = addNodeWithRecursiveCall(node.rightChild, inputValue);
            } else {
                System.out.println("기존 노드와 동일한 값을 가진 노드는 추가할 수 없습니다.");
            }
        }
        return node;
    }

    /**
     * 노드 삭제
     *
     * @param node        루트 노드
     * @param removeValue 삭제할 값 - 해당 값을 지닌 노드를 찾아서 삭제하는 함수
     * @return 루트 노드
     */
    public static Node removeNode(Node node, int removeValue) {
        if (node == null) return null;

        if (node.value > removeValue) {
            node.leftChild = removeNode(node.leftChild, removeValue);

        } else if (node.value < removeValue) {
            node.rightChild = removeNode(node.rightChild, removeValue);

        } else { //node.value == removeValue
            if (node.leftChild != null && node.rightChild != null) {
                //자식이 둘 다 존재하는 경우, 삭제할 노드의 자리에 자기 다음으로 큰 노드의 값을 넣는다.
                //자기 다음으로 큰 노드 = 자기 자신의 오른쪽 자식 노드들 중에서 가장 작은 노드.
                Node minNode = findMinValueNode(node.rightChild);
                node.value = minNode.value;

                //삭제 노드 자리에 대신 들어간 노드는 원래 자리에서 삭제.
                node.rightChild = removeNode(node.rightChild, minNode.value);
            } else if (node.leftChild != null || node.rightChild != null) {
                //자식이 하나만 존재하는 경우, 자식 노드를 부모 자리에 넣음.
                node = (node.leftChild != null) ? node.leftChild : node.rightChild;
            } else {
                //자식이 없는 경우.
                node = null;
            }
        }

        return node;
    }

    /**
     * 이진 탐색 트리의 가장 작은 원소 찾기 함수
     * - 이진 탐색 트리에서는 왼쪽 자식이 더 작은 값을 가지므로 leftChild만 확인하면 된다.
     *
     * @param node 탐색 기준 노드
     * @return
     */
    public static Node findMinValueNode(Node node) {
        Node nextNode = node;
        while (nextNode.leftChild != null) {
            nextNode = nextNode.leftChild;
        }
        return nextNode;
    }

    /**
     * 노드 탐색 - 특정 값을 가진 노드를 찾아서 반환
     *
     * @param node    루트 노드
     * @param keyword 검색 값
     * @return
     */
    public static Node searchNode(Node node, int keyword) {
        if (keyword < node.value) {
            return searchNode(node.leftChild, keyword);
        } else if (keyword > node.value) {
            return searchNode(node.rightChild, keyword);
        } else {
            return node; //node.value == keyword
        }
    }

    /**
     * 이진 트리의 전위 순회
     * 1. 자기 자신을 출력한다.
     * 2. 왼쪽 자식을 방문한다.
     * 3. 오른쪽 자식을 방문한다.
     *
     * @param node Root Node
     */
    public static void printNode(Node node) {
        System.out.printf("%d ", node.value);
        if (node.leftChild != null) {
            printNode(node.leftChild);
        }
        if (node.rightChild != null) {
            printNode(node.rightChild);
        }
    }


    /**
     * 트리의 노드 구조체
     */
    public static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
