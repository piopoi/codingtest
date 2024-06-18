package publiccode.datastructure;

import java.util.Arrays;

/**
 * 우선순위 큐(PriorityQueue) - 최대 힙 (Max Heap)으로 구현
 */
public class PriorityQueue {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //최대 힙 생성
        Heap maxHeap = new Heap(arr.length);

        //push
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[PUSH] STEP " + i);
            System.out.println("before " + maxHeap);
            maxHeap.push(arr[i]);
            System.out.println("push value = " + arr[i]);
            System.out.println("after " + maxHeap + "\n");
        }

        //pop
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[POP] STEP " + i);
            System.out.println("before " + maxHeap);
            int popVal = maxHeap.pop();
            System.out.println("pop value = " + popVal);
            System.out.println("after " + maxHeap + "\n");
        }
    }

    /**
     * 최대 힙 (Max Heap)
     */
    public static class Heap {
        int[] arr;
        int nodeCount = 0;

        public Heap(int size) {
            this.arr = new int[size];
        }

        /**
         * 노드 추가
         *
         * @param x 추가할 노드의 값
         */
        public void push(int x) {
            //Step1. 노드 추가
            arr[nodeCount] = x; //내부 데이터 끝자리에 새 데이터 추가
            nodeCount++; //데이터 개수 증가

            //Step2. 상향식 힙 재구성
            if (nodeCount == 1) {
                return; //새로 추가한 데이터가 root node라면 종료
            }
            int childIdx = nodeCount - 1;
            int parentIdx;
            while (childIdx > 0) {
                parentIdx = (childIdx - 1) / 2;
                if (arr[childIdx] > arr[parentIdx]) {
                    //swap
                    int tmp = arr[childIdx];
                    arr[childIdx] = arr[parentIdx];
                    arr[parentIdx] = tmp;

                    //부모 인덱스(parentIdx)에서 다시 값 크기 비교 및 swap 실행
                    childIdx = parentIdx;
                } else {
                    return;
                }
            }
        }

        /**
         * 노드 추출
         *
         * @return root node 값
         */
        public int pop() {
            //Step1. root node 값 추출
            int returnVal = arr[0];

            //Step2. 마지막 index의 원소를 루트 노드로 삽입
            arr[0] = arr[nodeCount - 1]; //루트 노드에 마지막 노드 값을 넣어주고 이후에 하향식으로 힙 재구성
            arr[nodeCount - 1] = 0; //루트 노드로 옮겼으니 마지막 노드는 초기화
            nodeCount--;

            //Step3. 하향식 힙 재구성
            int parentIdx = 0;
            int leftChildIdx = parentIdx * 2 + 1;
            int rightChildIdx;
            int chgIdx = parentIdx;
            while (leftChildIdx < nodeCount) {
                if (arr[leftChildIdx] > arr[parentIdx]) {
                    chgIdx = leftChildIdx;
                }

                rightChildIdx = leftChildIdx + 1;
                if (rightChildIdx < nodeCount && arr[rightChildIdx] > arr[chgIdx]) {
                    chgIdx = rightChildIdx;
                }

                //부모 노드 값이 가장 큰 값이면 반복문 stop
                if (parentIdx == chgIdx) {
                    break;
                }

                //swap
                int tmp = arr[parentIdx];
                arr[parentIdx] = arr[chgIdx];
                arr[chgIdx] = tmp;

                //자식 인덱스(largestValIdx)에서 다시 값 크기 비교 및 swap 실행
                parentIdx = chgIdx;
                leftChildIdx = parentIdx * 2 + 1;
            }

            return returnVal;
        }

        @Override
        public String toString() {
            return "heap=" + Arrays.toString(arr) + ", nodeCount=" + nodeCount;
        }
    }
}
