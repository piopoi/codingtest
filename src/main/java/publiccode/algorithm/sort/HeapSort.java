package publiccode.algorithm.sort;

import common.Util;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 힙 정렬(Heap Sort)
 * - 우선순위 큐를 이용한 정렬
 *
 * 우선순위 큐 (Priority Queue)
 * - 데이터를 꺼낼 때 우선 순위가 높은 데이터가 가장 먼저 나온다.
 * - 운영체제의 작업 스케줄링, 정렬, 네트워크 관리 등 다양한 기술에 적용되고 있다.
 * - 일반적인 형태의 큐는 선형적인 형태이지만, 우선순위 큐는 트리(Tree) 구조로 보는 것이 합리적이다.
 * - 일반적으로 우선순위 큐는 최대 힙(Max Heap)을 이용해 구현한다.
 *
 * 최대 힙 (Max Heap)
 * - 부모 노드가 자식 노드보다 값이 큰 '완전 이진 트리'.
 * - 최대 힙의 `루트 노드`는 전체 트리에서 `가장 큰 값`을 가진다.
 */
public class HeapSort {
    public static void main(String[] args) {
        int n; //입력할 원소 개수
        int data;

        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        PriorityQueueStruct pq = new PriorityQueueStruct(new int[n], 0);

        for(int i = 0; i < n; i++){
            push(pq, s.nextInt());
        }

        System.out.println("pq = " + Arrays.toString(pq.heap));

        for(int i = 0; i < n; i++) {
            int result = pop(pq);
            System.out.printf("추출한 원소 = %d\n", result);
            System.out.println("pq = " + Arrays.toString(pq.heap));
        }
    }

    /**
     * 우선순위 큐의 삽입
     *
     * @param pq   우선순위 큐 구조체
     * @param data 삽입할 값
     */
    public static void push(PriorityQueueStruct pq, int data) {
        if (pq.count >= pq.heap.length) System.out.println("삽입 가능한 최대 원소 개수를 초과하였습니다.");

        pq.heap[pq.count] = data; // 완전이진트리와 같기 때문에 마지막에 원소 삽입된다.
        int now = pq.count; //지금 삽입된 원소의 index
        int parent = (pq.count - 1) / 2; //부모 노드의 index를 구하는 방법.

        //새 원소를 삽입한 이후에 상향식으로 힙을 구성한다.
        while (now > 0 && pq.heap[now] > pq.heap[parent]) { //부모노드 값보다 자식노드 값이 크다면
            Util.swap(pq.heap, now, parent); //heap 배열에서 now와 parent index의 value 값을 swap.
            now = parent;
            parent = (parent - 1) / 2; //parent의 부모 노드 index 구하기
        }
        pq.count++;
    }

    /**
     * 우선순위 큐의 추출
     *
     * @param pq 우선순위 큐 구조체
     */
    public static int pop(PriorityQueueStruct pq) {
        if (pq.count <= 0) System.out.println("추출할 원소가 없습니다.");

        //1. 루트 노드의 원소를 추출
        int result = pq.heap[0]; //추출할 원소 = 루트 노드

        //2. 마지막 index의 원소를 루트 노드로 삽입
        pq.count--; //last index = length - 1
        pq.heap[0] = pq.heap[pq.count]; //루트 노드에 마지막 원소 넣기
        pq.heap[pq.count] = 0; //last index에서 원소 빠졌으니 0으로 변경

        //3. 하향식으로 힙 재구성
        int now = 0;
        int leftChild = 1;
        int rightChild = 2;
        int target = now;
        while (leftChild < pq.count) {
            if (pq.heap[target] < pq.heap[leftChild]) target = leftChild;

            if (pq.heap[target] < pq.heap[rightChild]
                    && rightChild < pq.count) //rightChild가 index 값을 벗어나치 않도록 조건 추가
                target = rightChild;

            if(target == now) {
                //자식 노드보다 현재 노드 원소가 더 크면 내려가지 않아도 되므로 종료
                break;
            } else {
                Util.swap(pq.heap, now, target);
                now = target;
                leftChild = now * 2 + 1;
                rightChild = now * 2 + 2;
            }
        }

        return result;
    }
}

/**
 * 우선순위 큐 구조체
 */
class PriorityQueueStruct {
    int[] heap;
    int count; //현재 heap 배열 내 원소 개수

    public PriorityQueueStruct(int[] heap, int count) {
        this.heap = heap;
        this.count = count;
    }
}
