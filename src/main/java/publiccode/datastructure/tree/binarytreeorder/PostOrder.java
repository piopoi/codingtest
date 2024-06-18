package publiccode.datastructure.tree.binarytreeorder;

/**
 * 이진 트리의 순회
 *
 * 후위 순회
 *
 * 1. 왼쪽 자식을 방문한다.
 * 2. 오른쪽 자식을 방문한다.
 * 3. 자기 자신을 출력한다.
 */
public class PostOrder {

    public static void main(String[] args) {
        Node n7 = new Node(50, null, null);
        Node n6 = new Node(37, null, null);
        Node n5 = new Node(23, null, null);
        Node n4 = new Node(5, null, null);
        Node n3 = new Node(48, n6, n7);
        Node n2 = new Node(17, n4, n5);
        Node n1 = new Node(30, n2, n3);

        //후위 순회
        postOrder(n1);
    }

    public static void postOrder(Node root) {
        if(root != null) {
            postOrder(root.leftChild);              //1. 왼쪽 자식을 방문한다.
            postOrder(root.rightChild);             //2. 오른쪽 자식을 방문한다.
            System.out.printf("%s ", root.data);    //3. 자기 자신을 출력한다.
        }
    }
}

